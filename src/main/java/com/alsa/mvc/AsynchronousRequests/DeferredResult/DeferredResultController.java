package com.alsa.mvc.AsynchronousRequests.DeferredResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 17:13
 * @Description:
 */
@RestController
@RequestMapping(value = "/deferred-result")
public class DeferredResultController{
    @Autowired
    private DeferredResultService deferredResultService;

    private final String requestId = "haha";


    @GetMapping(value = "/get")
    public DeferredResult<DeferredResultResponse> get(@RequestParam(value = "timeout",required = false,defaultValue = "10000") Long timeout){
        DeferredResult<DeferredResultResponse> deferredResult = new DeferredResult<>(timeout);
        deferredResultService.process(requestId,deferredResult);
        return deferredResult;
    }
}
