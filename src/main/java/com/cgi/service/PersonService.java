package com.cgi.service;

import com.cgi.model.Person;

import java.util.List;

public interface PersonService {
    //default CRUD operations
    List<Person> getPersonList();
    void addPerson(Person person);
    void deletePersonById(Integer id);

    void deletePerson(Person person);

    //custom methods
    Person findByLastName(String lastName);
    Person findByFirstNameAndLastName(String firstName, String lastName, String age);
}
