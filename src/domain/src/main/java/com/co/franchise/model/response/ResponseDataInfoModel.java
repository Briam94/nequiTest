package com.co.franchise.model.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDataInfoModel {

    private String code;
    private String message;
    private Object data;
}
