package com.co.franchise.use_case;

import com.co.franchise.driven_port.repository.ProductServicePort;
import com.co.franchise.model.ProductModel;
import com.co.franchise.model.response.ResponseDataInfoModel;
import com.co.franchise.model.response.ResponseDataModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import static com.co.franchise.utils.Constants.SAVE_NEW_PRODUCT_SUCCESSFULLY;

@AllArgsConstructor
@Log4j2
public class ProductUseCase {

    private final ProductServicePort productServicePort;

    public ResponseDataModel saveNewProduct(String name, int stock) {
        ResponseDataModel responseDataModel = new ResponseDataModel();
        ResponseDataInfoModel responseDataInfoModel = new ResponseDataInfoModel();
        productServicePort.saveNewProduct(new ProductModel(name, stock));
        responseDataInfoModel.setCode(String.valueOf(HttpStatus.OK.value()));
        responseDataInfoModel.setMessage(SAVE_NEW_PRODUCT_SUCCESSFULLY);
        responseDataModel.setResponse(responseDataInfoModel);
        return responseDataModel;
    }
}
