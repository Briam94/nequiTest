package com.co.franchise.driven_adapters.dynamo.mappers;

import com.co.franchise.driven_adapters.dynamo.entity.FranchiseEntity;
import com.co.franchise.entry_points.rest.controller.dto.AddedSubsidiaryFranchiseDto;
import com.co.franchise.model.FranchiseModel;
import com.co.franchise.model.FranchiseSubsidiaryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FranchiseMapper {

    FranchiseEntity franchiseModelToEntity(FranchiseModel franchiseModel);
    FranchiseModel franchiseEntityToModel(FranchiseEntity franchiseEntity);
    List<FranchiseSubsidiaryModel> addedSubsidiaryFranchiseDtoListToFranchiseSubsidiaryModelList(List<AddedSubsidiaryFranchiseDto> addedSubsidiaryFranchiseDto);
}
