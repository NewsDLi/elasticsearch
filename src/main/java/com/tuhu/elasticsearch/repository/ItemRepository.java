package com.tuhu.elasticsearch.repository;

import com.tuhu.elasticsearch.model.User;

/**
 * @Author lishenshen
 * @Date 2019/11/21 18:12
 * @Desc TODO
 */
public interface ItemRepository extends org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository<User, Long> {
}
