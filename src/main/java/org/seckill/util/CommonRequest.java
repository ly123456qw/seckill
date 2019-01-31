package org.seckill.util;

/**
 * 封装接口返回数据
 */
public class CommonRequest {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回成功状态
     */
    private Boolean isSuccess;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据对象
     */
    private Object result;

    /**
     * 唯一的数据对象
     * @param result
     */
    public CommonRequest(Object result) {
        this.result = result;
    }

    /**
     * 返回 状态码、状态、消息、数据对象
     * @param code
     * @param isSuccess
     * @param message
     * @param result
     */
    public CommonRequest(Integer code, Boolean isSuccess, String message, Object result) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.message = message;
        this.result = result;
    }

    /**
     * 返回 状态码、状态、数据对象
     * @param code
     * @param isSuccess
     * @param result
     */
    public CommonRequest(Integer code, Boolean isSuccess, Object result) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.result = result;
    }

    /**
     * 返回 状态码、状态、消息
     * @param code
     * @param isSuccess
     * @param message
     */
    public CommonRequest(Integer code, Boolean isSuccess, String message) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
