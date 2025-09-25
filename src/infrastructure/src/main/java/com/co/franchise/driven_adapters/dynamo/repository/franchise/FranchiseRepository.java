package com.co.franchise.driven_adapters.dynamo.repository.franchise;

import com.co.franchise.driven_adapters.dynamo.entity.FranchiseEntity;

public interface FranchiseRepository {

    void saveFranchise(FranchiseEntity franchiseEntity);
}
