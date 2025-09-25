package com.co.franchise.entry_points.rest.controller.franchise;

import com.co.franchise.driven_adapters.dynamo.mappers.FranchiseMapper;
import com.co.franchise.entry_points.rest.controller.dto.AddedSubsidiaryFranchiseRequestDto;
import com.co.franchise.entry_points.rest.controller.dto.FranchiseRequestDto;
import com.co.franchise.entry_points.rest.controller.dto.UpdateDataDto;
import com.co.franchise.use_case.FranchiseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.co.franchise.entry_points.utils.RouterConstants.FRANCHISE_REQUEST_PATH;


@RestController
@RequestMapping(FRANCHISE_REQUEST_PATH)
@AllArgsConstructor
public class FranchiseControllerImp implements FranchiseController {

    private final FranchiseUseCase franchiseUseCase;
    private final FranchiseMapper franchiseMapper;

    @Override
    public ResponseEntity<Object> saveNewFranchise(FranchiseRequestDto franchiseRequestDto) {
        return new ResponseEntity<>(
                franchiseUseCase.saveFranchise(franchiseRequestDto.getFranchiseName(),
                        franchiseMapper.addedSubsidiaryFranchiseDtoListToFranchiseSubsidiaryModelList(franchiseRequestDto.getSubsidiaries())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> addNewSubsidiaryFranchise(AddedSubsidiaryFranchiseRequestDto franchiseRequestDto) {
        return new ResponseEntity<>(
                franchiseUseCase.addSubsidiaryToFranchise(franchiseRequestDto.getFranchiseId(),
                        franchiseMapper.franchiseSubsidiaryDtoToModel(franchiseRequestDto.getSubsidiary())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllFranchise(String franchiseId) {
        return new ResponseEntity<>(
                franchiseUseCase.productsFranchise(franchiseId),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateFranchise(UpdateDataDto updateDataDto) {
        return new ResponseEntity<>(
                franchiseUseCase.updateFranchiseName(updateDataDto.getDataId(), updateDataDto.getNewName()),
                HttpStatus.OK);
    }
}
