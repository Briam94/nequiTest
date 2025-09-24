package com.co.franchise.entry_points.rest.controller.product;

import com.co.franchise.entry_points.rest.controller.dto.ProductRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.co.franchise.entry_points.utils.RouterConstants.*;

public interface ProductController {

    @PostMapping(value = NEW_PRODUCT_PATH)
    public ResponseEntity<Object> saveNewProduct(@RequestBody ProductRequestDto productRequestDto);

    @PutMapping(value = DELETE_PRODUCT_PATH)
    public ResponseEntity<Object> deleteProduct(
            @RequestHeader(name = HEADER_PRODUCT_NAME_DELETE) String productName);

    @PutMapping(value = UPDATE_PRODUCT_PATH)
    public ResponseEntity<Object> updateProduct(@RequestBody ProductRequestDto productRequestDto);
}
