package com.co.franchise.entry_points.rest.controller.Subsidiary;

import com.co.franchise.driven_adapters.dynamo.mappers.ProductMapper;
import com.co.franchise.entry_points.rest.controller.dto.AddedProductSubsidiaryDto;
import com.co.franchise.entry_points.rest.controller.dto.SubsidiaryRequestDto;
import com.co.franchise.use_case.SubsidiaryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.co.franchise.entry_points.utils.RouterConstants.SUBSIDIARY_REQUEST_PATH;

@RestController
@RequestMapping(SUBSIDIARY_REQUEST_PATH)
@AllArgsConstructor
public class SubsidiaryControllerImp implements SubsidiaryController {

    private final SubsidiaryUseCase subsidiaryUseCase;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<Object> saveNewSubsidiary(SubsidiaryRequestDto subsidiaryRequestDto) {
        return new ResponseEntity<>(
                subsidiaryUseCase.saveSubsidiary(subsidiaryRequestDto.getSubsidiaryName(),
                        productMapper.productRequestDtoListToModelList(subsidiaryRequestDto.getProducts())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> addedNewProductToSubsidiary(AddedProductSubsidiaryDto addedProductSubsidiaryDto) {
        return new ResponseEntity<>(
                subsidiaryUseCase.addProductToSubsidiary(addedProductSubsidiaryDto.getSubsidiaryId(),
                        productMapper.productSubsidiaryRequestDtoToProductSubsidiaryModel(addedProductSubsidiaryDto.getProduct())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> removeProductToSubsidiary(AddedProductSubsidiaryDto addedProductSubsidiaryDto) {
        return new ResponseEntity<>(
                subsidiaryUseCase.removeProductFromSubsidiary(addedProductSubsidiaryDto.getSubsidiaryId(),
                        productMapper.productSubsidiaryRequestDtoToProductSubsidiaryModel(addedProductSubsidiaryDto.getProduct())), HttpStatus.OK);
    }
}
