package com.co.franchise.driven_adapters.dynamo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubsidiaryEntity {

    private String subsidiaryId;
    private String subsidiaryName;
    private List<ProductSubsidiaryEntity> products;

    @DynamoDbPartitionKey
    public String getSubsidiaryId() {
        return subsidiaryId;
    }
}
