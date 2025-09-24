package com.co.franchise.entry_points.rest.controller.product;

import com.co.franchise.entry_points.rest.controller.dto.ProductRequestDto;
import com.co.franchise.use_case.ProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.co.franchise.entry_points.utils.RouterConstants.PRODUCT_REQUEST_PATH;

@RestController
@RequestMapping(PRODUCT_REQUEST_PATH)
@AllArgsConstructor
public class ProductControllerImp implements ProductController {

    private final ProductUseCase productUseCase;

    @Override
    public ResponseEntity<Object> saveNewProduct(ProductRequestDto productRequestDto) {
        return new ResponseEntity<>(
                productUseCase.saveNewProduct(productRequestDto.getName(), productRequestDto.getStock()), HttpStatus.OK);
    }
}
