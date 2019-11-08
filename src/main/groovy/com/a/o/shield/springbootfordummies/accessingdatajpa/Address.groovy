package com.a.o.shield.springbootfordummies.accessingdatajpa

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String street
    String wards
    String district
    int zipCode

    protected Address(){}

    Address(int zipCode) {
        this.zipCode = zipCode
    }
}
