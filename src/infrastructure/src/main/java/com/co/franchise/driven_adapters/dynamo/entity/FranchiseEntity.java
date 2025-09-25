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
public class FranchiseEntity {

    private String franchiseId;
    private String franchiseName;
    private List<FranchiseSubsidiaryEntity> subsidiaries;

    @DynamoDbPartitionKey
    public String getFranchiseId() {
        return franchiseId;
    }
}
