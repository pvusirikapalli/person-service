package com.cgi.service;

import com.cgi.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getPersonList();
    void addPerson(Person person);
    Person findByFirstName(String firstName);
    Person findByLastName(String lastName);
    Person findByFirstNameAndLastName(String firstName, String lastName, String age);
}
