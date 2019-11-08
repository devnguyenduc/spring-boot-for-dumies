package com.a.o.shield.springbootfordummies.accessingdatajpa

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String firstName
    String lastName
    String emailAddress
    int age

    @ManyToOne(cascade = CascadeType.ALL)
    Address address

    protected Customer(){}

    Customer(String firstName, String lastName, int age, Address address) {
        this.firstName = firstName
        this.lastName = lastName
        this.emailAddress = firstName?.toLowerCase() + lastName?.toLowerCase()
        this.age = age
        this.address = address
    }

    @Override
    String toString() {
        return String.format('Customer[id=%d, firstName="%s", lastName="%s, emailAddress=%s, age=%d"]'
                , id, firstName, lastName, emailAddress, age)
    }
}
