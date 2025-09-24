package com.co.franchise.driven_port.repository;

import com.co.franchise.model.ProductModel;

public interface ProductServicePort {

    void saveNewProduct(ProductModel productModel);
    ProductModel getProduct(String productName);
    void deleteProduct(String productName);
    void updateProduct(ProductModel productModel);
}
