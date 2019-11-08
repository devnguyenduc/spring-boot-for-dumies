package com.a.o.shield.springbootfordummies.accessingdatajpa

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String firstName
    String lastName

    protected Customer(){}

    Customer(String firstName, String lastName) {
        this.firstName = firstName
        this.lastName = lastName
    }

    @Override
    String toString() {
        return String.format('Customer[id=%d, firstName="%s", lastName="%s"]', id, firstName, lastName)
    }
}
