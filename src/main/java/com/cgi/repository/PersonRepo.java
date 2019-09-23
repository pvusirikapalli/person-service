package com.cgi.repository;

import com.cgi.model.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer>, PersonRepoCustom ,JpaSpecificationExecutor<Person> {
    Person findByFirstName(String firstName);
    Person findByLastName(String lastName);
}
