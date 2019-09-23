package com.cgi.repository;

import com.cgi.model.Person;
import com.cgi.specification.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonRepoImpl implements PersonRepoCustom{


    @Autowired EntityManager entityManager;

    @Override
    public Person findByFirstNameAndLastNameCustom(String firstName, String lastName) {
       CriteriaBuilder cb=entityManager.getCriteriaBuilder();

       CriteriaQuery<Person> cq=cb.createQuery(Person.class);
       Root<Person> person=cq.from(Person.class);
       Predicate firstNamePredicate=cb.equal(person.get("firstName"),firstName);
       Predicate lastNamePredicate=cb.equal(person.get("lastName"),lastName);
       cq.where(firstNamePredicate,lastNamePredicate);

        TypedQuery<Person> query=entityManager.createQuery(cq);

        return query.getResultList().get(0);
    }


}
