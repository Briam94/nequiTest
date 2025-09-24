package com.co.franchise.driven_adapters.dynamo.repository.product;

import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;

public interface ProductRepository {

    void saveNewProduct(ProductEntity productEntity);
    ProductEntity getProduct(String name);
}
