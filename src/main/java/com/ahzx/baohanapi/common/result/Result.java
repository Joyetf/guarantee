package com.ahzx.baohanapi.common.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final  long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private T result;

    public static Result success() {
        Result result = new Result();
        result.code = 200;
        result.setMessage("操作成功");
        result.setResult(null);
        return result;
    }

    public static <T> Result<T> success(T obj) {
        Result result = new Result();
        result.code = 200;
        result.setMessage("操作成功");
        result.setResult(obj);
        return result;
    }

    public static <T> Result<T> success(String message, T obj) {
        Result result = new Result();
        result.code = 200;
        result.setMessage(message);
        result.setResult(obj);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.code = 500;
        result.setMessage("操作失败");
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.code = 500;
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(String message, T obj) {
        Result result = new Result();
        result.code = 500;
        result.setMessage(message);
        result.setResult(obj);
        return result;
    }

}
