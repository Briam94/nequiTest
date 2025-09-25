package com.co.franchise.driven_adapters.dynamo.repository.franchise;

import com.co.franchise.driven_adapters.dynamo.mappers.FranchiseMapper;
import com.co.franchise.driven_port.repository.FranchiseServicePort;
import com.co.franchise.model.FranchiseModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@AllArgsConstructor
public class FranchisePortImp implements FranchiseServicePort {

    private final FranchiseMapper franchiseMapper;
    private final FranchiseRepository franchiseRepository;

    @Override
    public void saveFranchise(FranchiseModel franchiseModel) {
        log.info("Franchise to save: {},", franchiseModel.getFranchiseName());
        franchiseRepository.saveFranchise(franchiseMapper.franchiseModelToEntity(franchiseModel));
    }

    @Override
    public FranchiseModel getFranchise(String franchiseId) {
        log.info("getting franchise: {}", franchiseId);
        return franchiseMapper.franchiseEntityToModel(franchiseRepository.getFranchise(franchiseId));
    }

    @Override
    public void updateFranchise(FranchiseModel franchiseEntity) {
        log.info("franchise to update: {}", franchiseEntity.getFranchiseName());
        franchiseRepository.updateFranchise(franchiseMapper.franchiseModelToEntity(franchiseEntity));
    }
}
