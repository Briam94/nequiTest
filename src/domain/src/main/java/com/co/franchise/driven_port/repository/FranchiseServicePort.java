package com.co.franchise.driven_port.repository;

import com.co.franchise.model.FranchiseModel;

public interface FranchiseServicePort {

    void saveFranchise(FranchiseModel franchiseModel);
    FranchiseModel getFranchise(String franchiseId);
    void updateFranchise(FranchiseModel franchiseEntity);
}
