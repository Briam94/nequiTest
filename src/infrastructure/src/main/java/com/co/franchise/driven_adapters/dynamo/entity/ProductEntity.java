package com.co.franchise.driven_adapters.dynamo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductEntity {

    private String name;
    private int stock;

    @DynamoDbPartitionKey
    public String getName() {
        return name;
    }
}
