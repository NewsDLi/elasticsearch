package com.tuhu.elasticsearch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuhu.elasticsearch.model.User;
import com.tuhu.elasticsearch.repository.ItemRepository;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

/**
 * @Author lishenshen
 * @Date 2019/11/21 17:46
 * @Desc TODO
 */
@RestController
public class DemoController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ItemRepository itemRepository;


    @RequestMapping("/createIndex")
    public String createIndex(){
        // 创建索引，会根据Item类的@Document注解信息来创建
        boolean index = elasticsearchTemplate.createIndex(User.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        boolean b = elasticsearchTemplate.putMapping(User.class);
        return String.valueOf(index);
    }


    @RequestMapping("/addData")
    public String addData(){
        User user = new User();
        user.setId(new Date().getTime());
        user.setAge(20);
        user.setGender("就不给你说");
        user.setName("法号光亮");
        User save = itemRepository.save(user);
        return "succes";
    }

    @RequestMapping("/getData")
    public User getData (){
        Optional<User> byId = itemRepository.findById(1574388908684L);
        return byId.get();
    }

    @RequestMapping("/delData")
    public String delData (){
        itemRepository.deleteById(1574388908685L);
        return "success";
    }
}
