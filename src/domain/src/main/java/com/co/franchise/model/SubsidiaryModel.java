package com.co.franchise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubsidiaryModel {

    private String subsidiaryId;
    private String subsidiaryName;
    private List<ProductSubsidiaryModel> products;
}
