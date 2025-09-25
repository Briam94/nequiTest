package com.co.franchise.entry_points.rest.controller.dto;

import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Data
public class SubsidiaryRequestDto {

    private String subsidiaryName;
    private List<ProductSubsidiaryRequestDto> products;
}
