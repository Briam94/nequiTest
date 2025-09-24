package com.co.franchise.driven_adapters.dynamo.repository.product;

import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;
import com.co.franchise.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.*;

@Repository
@Log4j2
@AllArgsConstructor
public class ProductRepositoryImp implements ProductRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;


    @Override
    public void saveNewProduct(ProductEntity productEntity) {
        DynamoDbTable<ProductEntity> table = getTable();
        table.putItem(productEntity);
        log.info("product: {} saved with stock: {}", productEntity.getName(), productEntity.getStock());
    }

    @Override
    public ProductEntity getProduct(String name) {
        log.info("getting product: {}", name);
        try {
            DynamoDbTable<ProductEntity> table = getTable();

            return table.getItem(Key.builder()
                    .partitionValue(name)
                    .build());
        } catch (Exception e) {
            log.error(GETTING_TABLE_ERROR, e.getMessage());
            throw new BusinessException(STATUS_CODE_400, API_RESPONSE_400, STATUS_CODE_400, DYNAMO_DB_ERROR);
        }
    }

    @Override
    public void deleteProduct(String productName) {
        log.info("product to remove: {}", productName);
        try {
            DynamoDbTable<ProductEntity> table = getTable();

            table.deleteItem(Key.builder()
                    .partitionValue(productName)
                    .build());
        } catch (Exception e) {
            log.error(GETTING_TABLE_ERROR, e.getMessage());
            throw new BusinessException(STATUS_CODE_400, API_RESPONSE_400, STATUS_CODE_400, DYNAMO_DB_ERROR);
        }
    }

    @Override
    public void updateProduct(ProductEntity productEntity) {
        log.info("Update product: {}", productEntity.getName());
        try {
            DynamoDbTable<ProductEntity> table = getTable();
            table.updateItem(productEntity);
        } catch (Exception e) {
            log.error(GETTING_TABLE_ERROR, e.getMessage());
            throw new BusinessException(STATUS_CODE_400, API_RESPONSE_400, STATUS_CODE_400, DYNAMO_DB_ERROR);
        }
    }


    public DynamoDbTable<ProductEntity> getTable() {
        log.info("Getting table: {}", PRODUCT_TABLE_NAME);
        return dynamoDbEnhancedClient.table(PRODUCT_TABLE_NAME, TableSchema.fromClass(ProductEntity.class));
    }
}
