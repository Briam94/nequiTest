package com.co.franchise.entry_points.rest.controller.franchise;

import com.co.franchise.entry_points.rest.controller.dto.AddedSubsidiaryFranchiseRequestDto;
import com.co.franchise.entry_points.rest.controller.dto.FranchiseRequestDto;
import com.co.franchise.entry_points.rest.controller.dto.UpdateDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.co.franchise.entry_points.utils.RouterConstants.*;

public interface FranchiseController {

    @PostMapping(value = NEW_FRANCHISE_PATH)
    public ResponseEntity<Object> saveNewFranchise(@RequestBody FranchiseRequestDto franchiseRequestDto);

    @PutMapping(value = ADD_SUBSIDIARY_FRANCHISE_PATH)
    public ResponseEntity<Object> addNewSubsidiaryFranchise(@RequestBody AddedSubsidiaryFranchiseRequestDto franchiseRequestDto);

    @GetMapping(value = GET_ALL_FRANCHISE_PATH)
    public ResponseEntity<Object> getAllFranchise(@RequestHeader (name = HEADER_FRANCHISE_ID_DELETE) String franchiseId);

    @PutMapping(value = UPDATE_FRANCHISE_PATH)
    public ResponseEntity<Object> updateFranchise(@RequestBody UpdateDataDto updateDataDto);

}
