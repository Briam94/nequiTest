package com.co.franchise.driven_adapters.dynamo.repository.subsidiary;

import com.co.franchise.driven_adapters.dynamo.mappers.SubsidiaryMapper;
import com.co.franchise.driven_port.repository.SubsidiaryServicePort;
import com.co.franchise.model.SubsidiaryModel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@AllArgsConstructor
public class SubsidiaryPortImp implements SubsidiaryServicePort {

    private final SubsidiaryMapper subsidiaryMapper;
    private final SubsidiaryRepository subsidiaryRepository;

    @Override
    public void saveSubsidiary(SubsidiaryModel subsidiaryModel) {
        log.info("subsidiary to saved: {}", subsidiaryModel.getSubsidiaryName());
        subsidiaryRepository.saveSubsidiary(subsidiaryMapper.subsidiaryModelToEntity(subsidiaryModel));
    }

    @Override
    public void updateSubsidiary(SubsidiaryModel subsidiaryModel) {
        log.info("subsidiary to update: {}", subsidiaryModel.getSubsidiaryName());
        subsidiaryRepository.updateSubsidiary(subsidiaryMapper.subsidiaryModelToEntity(subsidiaryModel));
    }

    @Override
    public SubsidiaryModel getSubsidiary(String subsidiaryId) {
        log.info("subsidiary to get: {}", subsidiaryId);
        return subsidiaryMapper.subsidiaryEntityToModel(subsidiaryRepository.getSubsidiary(subsidiaryId));
    }
}
