package com.co.franchise.driven_adapters.dynamo.repository.franchise;

import com.co.franchise.driven_adapters.dynamo.entity.FranchiseEntity;
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
public class FranchiseRepositoryImp implements FranchiseRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    @Override
    public void saveFranchise(FranchiseEntity franchiseEntity) {
        DynamoDbTable<FranchiseEntity> table = getTable();
        table.putItem(franchiseEntity);
        log.info("franchise: {} saved ", franchiseEntity.getFranchiseName());
    }

    @Override
    public FranchiseEntity getFranchise(String franchiseId) {
        log.info("getting franchise: {}", franchiseId);
        try {
            DynamoDbTable<FranchiseEntity> table = getTable();

            return table.getItem(Key.builder()
                    .partitionValue(franchiseId)
                    .build());
        } catch (Exception e) {
            log.error(GETTING_TABLE_ERROR, e.getMessage());
            throw new BusinessException(STATUS_CODE_400, API_RESPONSE_400, STATUS_CODE_400, DYNAMO_DB_ERROR);
        }
    }

    @Override
    public void updateFranchise(FranchiseEntity franchiseEntity) {
        log.info("Update franchise: {}", franchiseEntity.getFranchiseName());
        try {
            DynamoDbTable<FranchiseEntity> table = getTable();
            table.updateItem(franchiseEntity);
        } catch (Exception e) {
            log.error(GETTING_TABLE_ERROR, e.getMessage());
            throw new BusinessException(STATUS_CODE_400, API_RESPONSE_400, STATUS_CODE_400, DYNAMO_DB_ERROR);
        }
    }

    public DynamoDbTable<FranchiseEntity> getTable() {
        log.info("Getting table: {}", FRANCHISE_TABLE_NAME);
        return dynamoDbEnhancedClient.table(FRANCHISE_TABLE_NAME, TableSchema.fromClass(FranchiseEntity.class));
    }
}
