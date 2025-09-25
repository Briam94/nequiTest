package com.co.franchise.use_case;

import com.co.franchise.driven_port.repository.FranchiseServicePort;
import com.co.franchise.driven_port.repository.ProductServicePort;
import com.co.franchise.driven_port.repository.SubsidiaryServicePort;
import com.co.franchise.model.*;
import com.co.franchise.model.response.ResponseDataInfoModel;
import com.co.franchise.model.response.ResponseDataModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.co.franchise.utils.Constants.*;

@AllArgsConstructor
@Log4j2
public class FranchiseUseCase {

    private final SubsidiaryServicePort subsidiaryServicePort;
    private final SubsidiaryUseCase subsidiaryUseCase;
    private final FranchiseServicePort franchiseServicePort;
    private final ProductUseCase productUseCase;

    public ResponseDataModel saveFranchise(String franchiseName, List<FranchiseSubsidiaryModel> subsidiaries) {
        log.info("Saving new franchise: {}", franchiseName);
        ResponseDataModel responseDataModel = new ResponseDataModel();
        ResponseDataInfoModel responseDataInfoModel = new ResponseDataInfoModel();
        for (FranchiseSubsidiaryModel franchiseSubsidiaryModel: subsidiaries) {
            if (!isProductInBd(franchiseSubsidiaryModel.getSubsidiaryId())) {
                log.info("the subsidiary {} is not in the data base.", franchiseSubsidiaryModel.getSubsidiaryId());
                responseDataInfoModel.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
                responseDataInfoModel.setMessage(SUBSIDIARY_IS_NOT_IN_DB);
                responseDataModel.setResponse(responseDataInfoModel);
                return responseDataModel;
            }
        }
        franchiseServicePort.saveFranchise(new FranchiseModel(String.valueOf(UUID.randomUUID()), franchiseName, subsidiaries));
        responseDataInfoModel.setCode(String.valueOf(HttpStatus.OK.value()));
        responseDataInfoModel.setMessage(SAVE_NEW_FRANCHISE_SUCCESSFULLY);
        responseDataModel.setResponse(responseDataInfoModel);
        return responseDataModel;
    }

    public ResponseDataModel addSubsidiaryToFranchise(String franchiseId, FranchiseSubsidiaryModel franchiseSubsidiaryModel) {
        ResponseDataModel responseDataModel = new ResponseDataModel();
        ResponseDataInfoModel responseDataInfoModel = new ResponseDataInfoModel();
        FranchiseModel franchiseModel = franchiseServicePort.getFranchise(franchiseId);
        if (Objects.isNull(franchiseModel)) {
            log.info("the franchise {} is not in the data base.", franchiseId);
            responseDataInfoModel.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
            responseDataInfoModel.setMessage(FRANCHISE_IS_NOT_IN_DB);
            responseDataModel.setResponse(responseDataInfoModel);
            return responseDataModel;
        }
        franchiseModel.getSubsidiaries().add(franchiseSubsidiaryModel);
        franchiseServicePort.updateFranchise(franchiseModel);
        responseDataInfoModel.setCode(String.valueOf(HttpStatus.OK.value()));
        responseDataInfoModel.setMessage(ADDED_NEW_SUBSIDIARY_FRANCHISE_SUCCESSFULLY);
        responseDataModel.setResponse(responseDataInfoModel);
        return responseDataModel;
    }

    public boolean isProductInBd(String subsidiaryId) {
        log.info("subsidiary to validate in data base: {}", subsidiaryId);
        SubsidiaryModel subsidiaryModel = subsidiaryServicePort.getSubsidiary(subsidiaryId);
        return !Objects.isNull(subsidiaryModel);
    }

    public FranchiseAllSubsidiaryModel productsFranchise(String franchiseId) {
        FranchiseModel franchiseModel = franchiseServicePort.getFranchise(franchiseId);
        List<SubsidiaryModel> subsidiariesModel = subsidiaryUseCase.getSubsidiaryByFranchise(franchiseModel.getSubsidiaries());
        List<SubsidiaryAllModel> subsidiaries = new ArrayList<>();
        for (SubsidiaryModel subsidiaryModel: subsidiariesModel) {
            SubsidiaryAllModel subsidiaryAllModel = new SubsidiaryAllModel(subsidiaryModel.getSubsidiaryId(), subsidiaryModel.getSubsidiaryName(),
                    productUseCase.getProductMaxStock(subsidiaryModel.getProducts()),
                    productUseCase.getProductsBySubsidiary(subsidiaryModel.getProducts()));
            subsidiaries.add(subsidiaryAllModel);
        }
        return new FranchiseAllSubsidiaryModel(
                franchiseModel.getFranchiseId(), franchiseModel.getFranchiseName(), subsidiaries
        );
    }
}
