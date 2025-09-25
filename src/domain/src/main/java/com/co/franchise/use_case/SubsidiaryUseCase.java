package com.co.franchise.use_case;

import com.co.franchise.driven_port.repository.SubsidiaryServicePort;
import com.co.franchise.model.ProductSubsidiaryModel;
import com.co.franchise.model.SubsidiaryModel;
import com.co.franchise.model.response.ResponseDataInfoModel;
import com.co.franchise.model.response.ResponseDataModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.co.franchise.utils.Constants.*;

@AllArgsConstructor
@Log4j2
public class SubsidiaryUseCase {

    private final SubsidiaryServicePort subsidiaryServicePort;
    private final ProductUseCase productUseCase;

    public ResponseDataModel saveSubsidiary(String subsidiaryName, List<ProductSubsidiaryModel> products) {
        log.info("Saving new subsidiary: {}", subsidiaryName);
        ResponseDataModel responseDataModel = new ResponseDataModel();
        ResponseDataInfoModel responseDataInfoModel = new ResponseDataInfoModel();
        for (ProductSubsidiaryModel productModel: products) {
            if (!productUseCase.isProductInBd(productModel.getName())) {
                log.info("the product {} is not in the data base.", productModel.getName());
                responseDataInfoModel.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
                responseDataInfoModel.setMessage(PRODUCT_IS_NOT_IN_DB);
                responseDataModel.setResponse(responseDataInfoModel);
                return responseDataModel;
            }
        }
        subsidiaryServicePort.saveSubsidiary(new SubsidiaryModel(UUID.randomUUID().toString(),
                subsidiaryName, products));
        responseDataInfoModel.setCode(String.valueOf(HttpStatus.OK.value()));
        responseDataInfoModel.setMessage(SAVE_NEW_SUBSIDIARY_SUCCESSFULLY);
        responseDataModel.setResponse(responseDataInfoModel);
        return responseDataModel;
    }

    public ResponseDataModel addProductToSubsidiary(String subsidiaryId, ProductSubsidiaryModel productSubsidiaryModel) {
        log.info("Updating subsidiary: {}, adding the product: {}", subsidiaryId, productSubsidiaryModel.getName());
        ResponseDataModel responseDataModel = new ResponseDataModel();
        ResponseDataInfoModel responseDataInfoModel = new ResponseDataInfoModel();
        if (!productUseCase.isProductInBd(productSubsidiaryModel.getName())) {
            log.info("the product {} is not in the data base.", productSubsidiaryModel.getName());
            responseDataInfoModel.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
            responseDataInfoModel.setMessage(PRODUCT_IS_NOT_IN_DB);
            responseDataModel.setResponse(responseDataInfoModel);
            return responseDataModel;
        }
        SubsidiaryModel subsidiaryModel = subsidiaryServicePort.getSubsidiary(subsidiaryId);
        if (Objects.isNull(subsidiaryModel)) {
            log.info("the subsidiary {} is not in the data base.", subsidiaryId);
            responseDataInfoModel.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
            responseDataInfoModel.setMessage(SUBSIDIARY_IS_NOT_IN_DB);
            responseDataModel.setResponse(responseDataInfoModel);
            return responseDataModel;
        }
        subsidiaryModel.getProducts().add(productSubsidiaryModel);
        subsidiaryServicePort.updateSubsidiary(subsidiaryModel);
        responseDataInfoModel.setCode(String.valueOf(HttpStatus.OK.value()));
        responseDataInfoModel.setMessage(ADDED_NEW_PRODUCT_SUBSIDIARY_SUCCESSFULLY);
        responseDataModel.setResponse(responseDataInfoModel);
        return responseDataModel;
    }

    public ResponseDataModel removeProductFromSubsidiary(String subsidiaryId, ProductSubsidiaryModel productSubsidiaryModel) {
        log.info("Remove {} from {}", productSubsidiaryModel.getName(), subsidiaryId);
        ResponseDataModel responseDataModel = new ResponseDataModel();
        ResponseDataInfoModel responseDataInfoModel = new ResponseDataInfoModel();
        SubsidiaryModel subsidiaryModel = subsidiaryServicePort.getSubsidiary(subsidiaryId);
        if (Objects.isNull(subsidiaryModel)) {
            log.info("the subsidiary {} is not in the data base.", subsidiaryId);
            responseDataInfoModel.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
            responseDataInfoModel.setMessage(SUBSIDIARY_IS_NOT_IN_DB);
            responseDataModel.setResponse(responseDataInfoModel);
            return responseDataModel;
        }
        subsidiaryModel.getProducts().remove(productSubsidiaryModel);
        log.info("the product {} was removed", productSubsidiaryModel.getName());
        subsidiaryServicePort.updateSubsidiary(subsidiaryModel);
        responseDataInfoModel.setCode(String.valueOf(HttpStatus.OK.value()));
        responseDataInfoModel.setMessage(ADDED_NEW_PRODUCT_SUBSIDIARY_SUCCESSFULLY);
        responseDataModel.setResponse(responseDataInfoModel);
        return responseDataModel;
    }

}
