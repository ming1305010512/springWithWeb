package com.alsa.mvc.AsynchronousRequests.DeferredResult;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2020/7/7
 * @Time: 17:14
 * @Description:
 */
public class DeferredResultResponse {

    private Integer code;
    private String msg;

    public enum Msg{
        TIMEOUT("超时"),
        FAILED("失败"),
        SUCCESS("成功");

        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        Msg(String desc) {
            this.desc = desc;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
