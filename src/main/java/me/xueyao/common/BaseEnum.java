package me.xueyao.common;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/1/21 15:37
 */
public enum  BaseEnum {
    BADPARAM(4001, "请求参数错误"),
    SUCCESS(2000, "请求成功"),
    BADEXCEPTION(4003, "业务处理失败");

    private Integer code;
    private String message;

    BaseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
