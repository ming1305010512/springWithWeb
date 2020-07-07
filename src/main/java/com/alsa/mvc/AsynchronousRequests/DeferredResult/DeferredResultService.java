package com.alsa.mvc.AsynchronousRequests.DeferredResult;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 17:14
 * @Description:
 */
@Service
public class DeferredResultService {

    private Map<String, Consumer<DeferredResultResponse>> taskMap;

    public DeferredResultService() {
        taskMap = new ConcurrentHashMap<>();
    }

    public void process(String requestId, DeferredResult<DeferredResultResponse> deferredResult){
        deferredResult.onTimeout(()->{
            taskMap.remove(requestId);
            DeferredResultResponse deferredResultResponse = new DeferredResultResponse();
            deferredResultResponse.setCode(HttpStatus.REQUEST_TIMEOUT.value());
            deferredResultResponse.setMsg(DeferredResultResponse.Msg.TIMEOUT.getDesc());
            deferredResult.setResult(deferredResultResponse);
        });

        Optional.ofNullable(taskMap)
                .filter(t->!t.containsKey(requestId))
                .orElseThrow(()->new IllegalArgumentException(String.format("requestId=%s is existing",requestId)));
        taskMap.putIfAbsent(requestId,deferredResult::setResult);
    }

    public void settingResult(String requestId,DeferredResultResponse deferredResultResponse){
        if (taskMap.containsKey(requestId)){
            Consumer<DeferredResultResponse> deferredResultResponseConsumer = taskMap.get(requestId);
            deferredResultResponseConsumer.accept(deferredResultResponse);
            taskMap.remove(requestId);
        }
    }
}
