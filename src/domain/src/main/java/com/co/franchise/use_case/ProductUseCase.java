package com.co.franchise.use_case;

import com.co.franchise.driven_port.repository.ProductServicePort;
import com.co.franchise.model.ProductModel;
import com.co.franchise.model.response.ResponseDataInfoModel;
import com.co.franchise.model.response.ResponseDataModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.util.Objects;

import static com.co.franchise.utils.Constants.NEW_PRODUCT_IS_IN_DB;
import static com.co.franchise.utils.Constants.SAVE_NEW_PRODUCT_SUCCESSFULLY;

@AllArgsConstructor
@Log4j2
public class ProductUseCase {

    private final ProductServicePort productServicePort;

    public ResponseDataModel saveNewProduct(String name, int stock) {
        log.info("the product to save is: {}", name);
        ResponseDataModel responseDataModel = new ResponseDataModel();
        ResponseDataInfoModel responseDataInfoModel = new ResponseDataInfoModel();
        if (isProductInBd(name)) {
            log.info("the product is already in the data base.");
            responseDataInfoModel.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            responseDataInfoModel.setMessage(NEW_PRODUCT_IS_IN_DB);
            responseDataModel.setResponse(responseDataInfoModel);
            return responseDataModel;
        }
        productServicePort.saveNewProduct(new ProductModel(name, stock));
        responseDataInfoModel.setCode(String.valueOf(HttpStatus.OK.value()));
        responseDataInfoModel.setMessage(SAVE_NEW_PRODUCT_SUCCESSFULLY);
        responseDataModel.setResponse(responseDataInfoModel);
        return responseDataModel;
    }

    public boolean isProductInBd(String productName) {
        ProductModel productModel = productServicePort.getProduct(productName);
        return !Objects.isNull(productModel);
    }
}
