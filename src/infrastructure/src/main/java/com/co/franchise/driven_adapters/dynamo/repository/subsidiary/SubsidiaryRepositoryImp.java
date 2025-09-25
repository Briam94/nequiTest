package com.co.franchise.driven_adapters.dynamo.repository.subsidiary;

import com.co.franchise.driven_adapters.dynamo.entity.SubsidiaryEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.SUBSIDIARY_TABLE_NAME;

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

    public DynamoDbTable<SubsidiaryEntity> getTable() {
        log.info("Getting table: {}", SUBSIDIARY_TABLE_NAME);
        return dynamoDbEnhancedClient.table(SUBSIDIARY_TABLE_NAME, TableSchema.fromClass(SubsidiaryEntity.class));
    }
}
