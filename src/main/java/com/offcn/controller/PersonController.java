package com.offcn.controller;

import com.offcn.bean.Person;
import com.offcn.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }
@GetMapping("/getAllPerson")
    public List<Person> getAllPerson(){

        return personRepository.findAll();
    }
@DeleteMapping("/deletePerson/{id}")
  public void  deletePerson(@PathVariable("id") Long id){
        personRepository.deleteById(id);
  }
@PutMapping("/updatePerson")
  public void updatePerson(@RequestBody Person person){

        personRepository.saveAndFlush(person);
  }

}
