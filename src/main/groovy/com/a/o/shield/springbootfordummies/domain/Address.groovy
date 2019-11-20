package com.a.o.shield.springbootfordummies.domain

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

    @Override
    String toString() {
        return String.format('Address[id=%d, street="%s", wards="%s", district=%s, zipCode=%d]'
                , id, street, wards, district, zipCode)
    }
}
