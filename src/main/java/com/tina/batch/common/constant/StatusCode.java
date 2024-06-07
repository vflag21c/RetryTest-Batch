package com.tina.batch.common.constant;

import lombok.Getter;

@Getter
public enum StatusCode {
    START("1", "시작"),
    IN_PROGRESS("2","진행중"),
    END("3","끝");

    String code;
    String description;

    StatusCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static StatusCode fromCode(String code) {
        for (StatusCode status : StatusCode.values()) {
            if (status.getCode().equalsIgnoreCase(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
