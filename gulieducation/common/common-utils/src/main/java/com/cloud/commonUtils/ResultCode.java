package com.cloud.commonUtils;

public enum ResultCode {
    success(20000), error(20001);
    private final  int value;

    ResultCode(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }
}
