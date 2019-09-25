package com.cgi.controller;

import com.cgi.model.Person;
import com.cgi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;

    @GetMapping(value = "/people")
    public List<Person> getPeople() {
        return personService.getPersonList();
    }

    @PostMapping(value = "/addPerson")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PostMapping(value = "/deletePerson/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePersonById(id);
    }

//    @GetMapping(value = "/person")
//    public Person findPersonByFirstName(@RequestParam(value = "firstName") String firstName){
//      return personService.findByFirstName(firstName);
//    }

//    @GetMapping(value = "/person")
//    public Person findPersonBLastName(@RequestParam(value = "lastName") String lastName){
//        return personService.findByLastName(lastName);
//    }

    @GetMapping(value = "/person")
    public Person findPersonByFirstNameAndLastName(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "age") String age) {
        return personService.findByFirstNameAndLastName(firstName, lastName,age);
    }
}
