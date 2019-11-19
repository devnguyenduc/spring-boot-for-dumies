package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.springframework.data.jpa.domain.Specification

import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class CustomerSpecification implements Specification<Customer> {

    private final int age
    private final String firstName

    CustomerSpecification(int age, String firstName) {
        this.age = age
        this.firstName = firstName
    }

    @Override
    Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = [criteriaBuilder.greaterThan(root.get('age'), age)]

        predicates << criteriaBuilder.equal(root.get('firstName'), firstName)

        criteriaBuilder & (predicates as Predicate[])
    }
}
