package com.cgi.specification;

import com.cgi.model.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonSpecification{

    //specification with anonymous inner class
    public static Specification<Person> hasFirstName(String firstName) {

        return new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate firstNamePredicate = cb.equal(root.get("firstName"), firstName);
                return firstNamePredicate;
            }
        };
    }

    //above method with lambda expression
    public static Specification<Person> hasLastName(String lastName) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("lastName"),lastName);
        };
    }

    //Simplified lambda expression
    public static Specification<Person> hasAge(String age){
        return (root, query, criteriaBuilder) ->  criteriaBuilder.equal(root.get("age"),age);
    }
}
