package com.co.franchise.entry_points.rest.controller.Subsidiary;

import com.co.franchise.entry_points.rest.controller.dto.AddedProductSubsidiaryDto;
import com.co.franchise.entry_points.rest.controller.dto.SubsidiaryRequestDto;
import com.co.franchise.entry_points.rest.controller.dto.UpdateDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.co.franchise.entry_points.utils.RouterConstants.*;

public interface SubsidiaryController {

    @PostMapping(value = NEW_SUBSIDIARY_PATH)
    public ResponseEntity<Object> saveNewSubsidiary(@RequestBody SubsidiaryRequestDto subsidiaryRequestDto);

    @PutMapping(value = ADDED_NEW_PRODUCT_SUBSIDIARY_PATH)
    public ResponseEntity<Object> addedNewProductToSubsidiary(@RequestBody AddedProductSubsidiaryDto addedProductSubsidiaryDto);

    @DeleteMapping(value = REMOVE_PRODUCT_SUBSIDIARY_PATH)
    public ResponseEntity<Object> removeProductToSubsidiary(@RequestBody AddedProductSubsidiaryDto addedProductSubsidiaryDto);

    @PutMapping(value = UPDATE_SUBSIDIARY_PATH)
    public ResponseEntity<Object> update(@RequestBody UpdateDataDto updateDataDto);
}
