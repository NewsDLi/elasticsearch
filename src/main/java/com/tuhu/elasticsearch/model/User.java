package com.tuhu.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author lishenshen
 * @Date 2019/11/21 17:51
 * @Desc TODO
 */
@Data
@Document(indexName = "user",type = "docs", shards = 1, replicas = 0)
public class User {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(index = false, type = FieldType.Keyword)
    private String gender;
}
