package com.co.franchise.driven_adapters.dynamo.mappers;
import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;
import com.co.franchise.entry_points.rest.controller.dto.ProductRequestDto;
import com.co.franchise.entry_points.rest.controller.dto.ProductSubsidiaryRequestDto;
import com.co.franchise.model.ProductModel;
import com.co.franchise.model.ProductSubsidiaryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductEntity productModelToEntity(ProductModel productModel);
    ProductModel productEntityToModel(ProductEntity productEntity);
    List<ProductSubsidiaryModel> productRequestDtoListToModelList(List<ProductSubsidiaryRequestDto> products);
}
