package com.co.franchise.driven_adapters.dynamo.repository.product;

import com.co.franchise.driven_adapters.dynamo.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import static com.co.franchise.driven_adapters.dynamo.utils.DynamoDbConstants.PRODUCT_TABLE_NAME;

@Repository
@Log4j2
@AllArgsConstructor
public class ProductRepositoryImp implements ProductRepository{

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;


    @Override
    public void saveNewProduct(ProductEntity productEntity) {
        DynamoDbTable<ProductEntity> table = getSubscribeTable();
        table.putItem(productEntity);
        log.info("product: {} saved with stock: {}", productEntity.getName(), productEntity.getStock());
    }


    public DynamoDbTable<ProductEntity> getSubscribeTable() {
        log.info("Getting table: {}", PRODUCT_TABLE_NAME);
        return dynamoDbEnhancedClient.table(PRODUCT_TABLE_NAME, TableSchema.fromClass(ProductEntity.class));
    }
}
