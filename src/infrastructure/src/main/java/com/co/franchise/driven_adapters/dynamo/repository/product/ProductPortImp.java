package com.co.franchise.driven_adapters.dynamo.repository.product;

import com.co.franchise.driven_adapters.dynamo.mappers.ProductMapper;
import com.co.franchise.driven_port.repository.ProductServicePort;
import com.co.franchise.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@AllArgsConstructor
public class ProductPortImp implements ProductServicePort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void saveNewProduct(ProductModel productModel) {
        log.info("Product to save, name: {}, with stock: {}", productModel.getName(), productModel.getStock());
        productRepository.saveNewProduct(productMapper.productModelToEntity(productModel));
    }
}
