package com.offcn.controller;

import com.offcn.bean.Person;
import com.offcn.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pers")
public class PersonController2 {

    @Autowired
    PersonRepository personRepository;


    //查询指定用户姓名的用户
    @GetMapping("/getPerson/{name}")

    public Person getPerson(@PathVariable("name") String name){

        return personRepository.getPerson(name);

    }

    //查询指定用户姓名和年龄都相同的用户
@GetMapping("/getLogin/{name}/{age}")
    public Person getLogin(@PathVariable("name") String name,@PathVariable("age") Integer age){

        return personRepository.getLogin(name,age);

    }


    //查询包含指定名字的用户
    @GetMapping("/getNamesLike/{name}")
    public List<Person> getNamesLike(@PathVariable("name") String name){


        return personRepository.getNamesLike(name);
    }



    //年龄是3位数的用户
@GetMapping("/getAgeisThree")
    public List<Person> getAgeisThree(){
        return personRepository.getAgeisThree();
    }

}
