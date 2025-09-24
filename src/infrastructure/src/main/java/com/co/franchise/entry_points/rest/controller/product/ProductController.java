package com.co.franchise.entry_points.rest.controller.product;

import com.co.franchise.entry_points.rest.controller.dto.ProductRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.co.franchise.entry_points.utils.RouterConstants.NEW_PRODUCT_PATH;

public interface ProductController {

    @PostMapping(value = NEW_PRODUCT_PATH)
    public ResponseEntity<Object> saveNewProduct(@RequestBody ProductRequestDto productRequestDto);
}
