package com.itor.base;

public class BaseResult {

    public static Result ok() {
        return new Result(200, "success", null);
    }

    public static Result ok(Object data) {
        return new Result(200, "success", data);
    }

    public static Result fail() {
        return new Result(500, "system busy", null);
    }
}
