package com.co.franchise.entry_points.rest.controller.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AddedSubsidiaryFranchiseRequestDto {

    String franchiseId;
    private AddedSubsidiaryFranchiseDto subsidiary;
}
