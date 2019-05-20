package com.offcn.controller;

import com.offcn.bean.Person;
import com.offcn.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/per3")
public class Person3Controller {

    @Autowired
    PersonRepository personRepository;


    // 排序查询，返回 list 集合
    @GetMapping("/fname/{sort}/{name}")
    public List<Person> findByNameContaining(@PathVariable String name, @PathVariable String sort){
        return personRepository.findByNameContaining(name,new Sort(Sort.Direction.fromString(sort),"id"));
    }
    //分页查询，查询计算总个数，总页数
    @GetMapping("/fname1/{page}/{size}/{sort}/{name}")
    public Page<Person> findByNamePage(@PathVariable String name,@PathVariable int page,@PathVariable int size,@PathVariable String sort){

        return personRepository.findByNameContaining(name, PageRequest.of(page, size,new Sort(Sort.Direction.fromString(sort),"id")));
    }

    //分页查询，返回的是一个片段，它只知道下一片段或者上一片段是否可用。
    @GetMapping("/fname2/{page}/{size}/{sort}/{name}")
    Slice<Person> getByNameContaining(@PathVariable String name, @PathVariable int page, @PathVariable int size, @PathVariable String sort){

        return personRepository.getByNameContaining(name,PageRequest.of(page, size, new Sort(Sort.Direction.fromString(sort),"id")));
    }




}
