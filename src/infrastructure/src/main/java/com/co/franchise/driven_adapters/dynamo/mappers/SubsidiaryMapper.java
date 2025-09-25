package com.co.franchise.driven_adapters.dynamo.mappers;

import com.co.franchise.driven_adapters.dynamo.entity.SubsidiaryEntity;
import com.co.franchise.model.SubsidiaryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubsidiaryMapper {

    SubsidiaryEntity subsidiaryModelToEntity(SubsidiaryModel subsidiaryModel);
    SubsidiaryModel subsidiaryEntityToModel(SubsidiaryEntity subsidiaryEntity);
}
