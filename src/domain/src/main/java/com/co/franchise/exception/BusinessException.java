package com.co.franchise.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{

    private final String status;
    private final String messageResponse;
    private final String code;
    private final String messageError;

    public BusinessException(String status, String messageResponse, String code, String messageError) {
        super(messageResponse);
        this.status = status;
        this.messageResponse = messageResponse;
        this.code = code;
        this.messageError = messageError;
    }
}
