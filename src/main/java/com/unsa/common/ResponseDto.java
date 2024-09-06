package com.unsa.common;

import lombok.Data;

@Data
public class ResponseDto<T> {
    private String status;
    private String message;
    private T data;

    private ResponseDto(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>("success", "operation successful", data);
    }

    public static <T> ResponseDto<T> error(String message) {
        return new ResponseDto<>("error", message, null);
    }

}
