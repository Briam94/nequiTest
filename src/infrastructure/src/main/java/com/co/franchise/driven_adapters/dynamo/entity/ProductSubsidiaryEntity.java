package com.co.franchise.driven_adapters.dynamo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductSubsidiaryEntity {

    private String name;
}
