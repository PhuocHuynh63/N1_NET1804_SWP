package com.n3.mebe.exception;

import lombok.Getter;

public enum ErrorCode {
    USER_EXIST(1001, "User existed"),
    INVALITE_MESSAGE_KEY(1002, "Invalid message key"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),;
    @Getter
    private int code;


    @Getter
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
