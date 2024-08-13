package com.unsa.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private String status;
    private String message;
    private Object data;

    public static ResponseDto success(String message, Object data) {
        return ResponseDto.builder()
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    public static ResponseDto fail(String message) {
        return ResponseDto.builder()
                .status("fail")
                .message(message)
                .data(null)
                .build();
    }

}
