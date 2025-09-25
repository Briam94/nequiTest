package com.co.franchise.entry_points.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseRequestDto {

    private String franchiseName;
    private List<AddedSubsidiaryFranchiseDto> subsidiaries;
}
