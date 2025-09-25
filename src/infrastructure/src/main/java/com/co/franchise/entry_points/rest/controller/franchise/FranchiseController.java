package com.co.franchise.entry_points.rest.controller.franchise;

import com.co.franchise.entry_points.rest.controller.dto.FranchiseRequestDto;
import com.co.franchise.entry_points.rest.controller.dto.ProductRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.co.franchise.entry_points.utils.RouterConstants.NEW_FRANCHISE_PATH;

public interface FranchiseController {

    @PostMapping(value = NEW_FRANCHISE_PATH)
    public ResponseEntity<Object> saveNewFranchise(@RequestBody FranchiseRequestDto franchiseRequestDto);

}
