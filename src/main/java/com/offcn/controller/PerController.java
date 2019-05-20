package com.offcn.controller;

import com.offcn.bean.Person;
import com.offcn.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/per")
public class PerController {

    @Autowired
    PersonRepository personRepository;


    //查询指定用户姓名的用户
    @GetMapping("/findByNameIs/{name}")

    public Person findByNameIs(@PathVariable("name") String name){

        return personRepository.findByNameIs(name);

    }

    //查询指定用户姓名和年龄都相同的用户
@GetMapping("/findByNameIsAndAge/{name}/{age}")
    public Person findByNameIsAndAge(@PathVariable("name")String name,@PathVariable("age")Integer age){

        return personRepository.findByNameIsAndAge(name,age);

    }


    //查询包含指定名字的用户
    @GetMapping("/findByNameContaining/{name}")
    public List<Person> findByNameContaining(@PathVariable("name")String name){


        return personRepository.findByNameContaining(name);
    }




}
