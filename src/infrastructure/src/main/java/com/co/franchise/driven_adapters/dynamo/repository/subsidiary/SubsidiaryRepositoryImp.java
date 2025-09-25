package com.co.franchise.driven_adapters.dynamo.repository.subsidiary;

import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;
import com.co.franchise.driven_adapters.dynamo.entity.SubsidiaryEntity;
import com.co.franchise.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.*;
import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.API_RESPONSE_400;
import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.DYNAMO_DB_ERROR;
import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.STATUS_CODE_400;

@Repository
@Log4j2
@AllArgsConstructor
public class SubsidiaryRepositoryImp implements SubsidiaryRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    @Override
    public void saveSubsidiary(SubsidiaryEntity subsidiaryEntity) {
        DynamoDbTable<SubsidiaryEntity> table = getTable();
        table.putItem(subsidiaryEntity);
        log.info("subsidiary to saved: {}", subsidiaryEntity.getSubsidiaryName());
    }

    @Override
    public void updateSubsidiary(SubsidiaryEntity subsidiaryEntity) {
        log.info("Update subsidiary: {}", subsidiaryEntity.getSubsidiaryName());
        try {
            DynamoDbTable<SubsidiaryEntity> table = getTable();
            table.updateItem(subsidiaryEntity);
        } catch (Exception e) {
            log.error(GETTING_TABLE_ERROR, e.getMessage());
            throw new BusinessException(STATUS_CODE_400, API_RESPONSE_400, STATUS_CODE_400, DYNAMO_DB_ERROR);
        }
    }

    @Override
    public SubsidiaryEntity getSubsidiary(String subsidiaryId) {
        log.info("getting subsidiary: {}", subsidiaryId);
        try {
            DynamoDbTable<SubsidiaryEntity> table = getTable();

            return table.getItem(Key.builder()
                    .partitionValue(subsidiaryId)
                    .build());
        } catch (Exception e) {
            log.error(GETTING_TABLE_ERROR, e.getMessage());
            throw new BusinessException(STATUS_CODE_400, API_RESPONSE_400, STATUS_CODE_400, DYNAMO_DB_ERROR);
        }
    }

    public DynamoDbTable<SubsidiaryEntity> getTable() {
        log.info("Getting table: {}", SUBSIDIARY_TABLE_NAME);
        return dynamoDbEnhancedClient.table(SUBSIDIARY_TABLE_NAME, TableSchema.fromClass(SubsidiaryEntity.class));
    }
}
