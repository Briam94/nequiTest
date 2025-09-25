package com.co.franchise.driven_adapters.dynamo.repository.subsidiary;

import com.co.franchise.driven_adapters.dynamo.entity.SubsidiaryEntity;

public interface SubsidiaryRepository {

    void saveSubsidiary(SubsidiaryEntity subsidiaryEntity);
    void updateSubsidiary(SubsidiaryEntity subsidiaryEntity);
    SubsidiaryEntity getSubsidiary(String subsidiaryId);
}
