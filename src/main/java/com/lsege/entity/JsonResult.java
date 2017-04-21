package com.lsege.entity;

import java.io.Serializable;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class JsonResult<T> implements Serializable {

    /**
     * 数据
     */
    private T data;
    /**
     * 信息
     */
    private String message;
    /**
     * 是否成功
     */
    private boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    @Override
    public String toString() {
        return "JsonResult{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
