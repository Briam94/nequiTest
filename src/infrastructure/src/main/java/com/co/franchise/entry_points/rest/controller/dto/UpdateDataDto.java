package com.co.franchise.entry_points.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDataDto {

    private String dataId;
    private String newName;
}
