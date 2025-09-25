package com.co.franchise.driven_port.repository;

import com.co.franchise.model.SubsidiaryModel;

public interface SubsidiaryServicePort {

    void saveSubsidiary(SubsidiaryModel subsidiaryModel);
    void updateSubsidiary(SubsidiaryModel subsidiaryModel);
    SubsidiaryModel getSubsidiary(String subsidiaryId);
}
