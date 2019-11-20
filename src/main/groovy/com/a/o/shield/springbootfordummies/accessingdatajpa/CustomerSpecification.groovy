package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.springframework.data.jpa.domain.Specification

import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class CustomerSpecification implements Specification<Customer> {

    private final Optional<Integer> age
    private final Optional<String> firstName

    CustomerSpecification(Optional<Integer> age, Optional<String> firstName) {
        this.age = age
        this.firstName = firstName
    }

    @Override
    Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = []

        age.map({int givenAge ->
            predicates << criteriaBuilder.greaterThan(root.get('age'), givenAge)
        })

        firstName.map({String givenFirstName ->
            predicates << criteriaBuilder.equal(root.get('firstName'), givenFirstName)
        })

        criteriaBuilder & (predicates as Predicate[])
    }
}
