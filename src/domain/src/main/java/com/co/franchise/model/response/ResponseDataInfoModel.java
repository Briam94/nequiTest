package com.co.franchise.model.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataInfoModel {

    private String code;
    private String message;
    private Object data;
}
