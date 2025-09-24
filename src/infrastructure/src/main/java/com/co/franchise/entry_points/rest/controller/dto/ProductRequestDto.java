package com.co.franchise.entry_points.rest.controller.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProductRequestDto {

    private String name;
    private int stock;
}
