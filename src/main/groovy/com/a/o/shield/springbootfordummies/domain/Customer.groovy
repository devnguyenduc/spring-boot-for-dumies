package com.a.o.shield.springbootfordummies.domain


import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String firstName
    String lastName
    String emailAddress
    int age

    @Temporal(TemporalType.DATE)
    Date lastVisited

    @ManyToOne
    @JoinColumn(name = 'address_id', referencedColumnName = 'id')
    Address address

    @Enumerated(EnumType.STRING)
    Type type

    protected Customer(){}

    Customer(String firstName, String lastName, int age, Address address, Type type = Type.NORMAL) {
        this.firstName = firstName
        this.lastName = lastName
        this.emailAddress = firstName?.toLowerCase() + lastName?.toLowerCase()
        this.age = age
        this.address = address
        this.lastVisited = new Date()
        this.type = type
    }

    @Override
    String toString() {
        return String.format('Customer[id=%d, firstName="%s", lastName="%s, emailAddress=%s, age=%d", type=%s]'
                , id, firstName, lastName, emailAddress, age, type)
    }
}
