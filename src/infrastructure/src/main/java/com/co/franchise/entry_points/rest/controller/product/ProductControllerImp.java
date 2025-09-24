package com.co.franchise.entry_points.rest.controller.product;

import com.co.franchise.entry_points.rest.controller.dto.ProductRequestDto;
import com.co.franchise.model.response.ResponseDataInfoModel;
import com.co.franchise.model.response.ResponseDataModel;
import com.co.franchise.use_case.ProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.co.franchise.entry_points.utils.RouterConstants.PRODUCT_REQUEST_PATH;
import static com.co.franchise.entry_points.utils.RouterConstants.UPDATE_PRODUCT_STOCK_MESSAGE;

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

    @Override
    public ResponseEntity<Object> deleteProduct(String productName) {
        productUseCase.deleteProduct(productName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateProduct(ProductRequestDto productRequestDto) {
        productUseCase.updateProduct(productRequestDto.getName(), productRequestDto.getStock());
        return new ResponseEntity<>(new ResponseDataModel(
                new ResponseDataInfoModel(
                        String.valueOf(HttpStatus.OK.value()),
                        UPDATE_PRODUCT_STOCK_MESSAGE, null)), HttpStatus.OK);
    }
}
