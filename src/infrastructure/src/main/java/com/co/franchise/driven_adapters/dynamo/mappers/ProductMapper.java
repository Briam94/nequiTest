package com.co.franchise.driven_adapters.dynamo.mappers;
import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;
import com.co.franchise.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductEntity productModelToEntity(ProductModel productModel);
    ProductModel productEntityToModel(ProductEntity productEntity);
}
