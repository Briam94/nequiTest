package com.co.franchise.driven_adapters.dynamo.repository.franchise;

import com.co.franchise.driven_adapters.dynamo.entity.FranchiseEntity;
import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.FRANCHISE_TABLE_NAME;

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

    public DynamoDbTable<FranchiseEntity> getTable() {
        log.info("Getting table: {}", FRANCHISE_TABLE_NAME);
        return dynamoDbEnhancedClient.table(FRANCHISE_TABLE_NAME, TableSchema.fromClass(FranchiseEntity.class));
    }
}
