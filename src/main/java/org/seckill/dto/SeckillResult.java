package org.seckill.dto;

// 所有 AJAX 请求返回类型，封装 JSON 结果
public class SeckillResult<T> {
    private boolean success;
    private T data;
    private String error;

    // 如果是 TRUE ，把结果返回
    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    // 如果是 FALSE ，把错误信息返回
    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
