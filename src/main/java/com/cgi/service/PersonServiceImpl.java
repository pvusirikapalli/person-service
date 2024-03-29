package com.cgi.service;

import com.cgi.model.Person;
import com.cgi.repository.PersonRepo;
import com.cgi.specification.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    public PersonRepo personRepo;

    @Override
    public List<Person> getPersonList() {
        return personRepo.findAll();
    }

    @Override
    public void addPerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void deletePersonById(Integer id) {
        personRepo.deleteById(id);
    }

    @Override
    public void deletePerson(Person person) {
        personRepo.delete(person);
    }


    @Override
    public Person findByLastName(String lastName) {
        return personRepo.findByLastName(lastName);
    }

    @Override
    public Person findByFirstNameAndLastName(String firstName, String lastName, String age) {
        return personRepo.findOne(PersonSpecification.hasFirstName(firstName)
                .and(PersonSpecification.hasLastName(lastName))
                .and(PersonSpecification.hasAge(age))).get();
    }
}
