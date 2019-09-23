package com.cgi.repository;

import com.cgi.model.Person;

public interface PersonRepoCustom  {
    Person findByFirstNameAndLastNameCustom(String firstName,String lastName);

}
