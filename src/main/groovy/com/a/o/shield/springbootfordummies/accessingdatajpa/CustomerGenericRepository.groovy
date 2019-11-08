package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.springframework.data.repository.Repository

interface CustomerGenericRepository extends Repository<Customer, Long> {
    List<Customer> findByEmailAddressAndLastName(String emailAddress, String lastname)

    // Enables the distinct flag for the query
    List<Customer> findDistinctPeopleByLastNameOrFirstName(String lastname, String firstname)
    List<Customer> findPeopleDistinctByLastNameOrFirstName(String lastname, String firstname)

    // Enabling ignoring case for an individual property
    List<Customer> findByLastNameIgnoreCase(String lastname)
    // Enabling ignoring case for all suitable properties
    List<Customer> findByLastNameAndFirstNameAllIgnoreCase(String lastname, String firstname)

    // Enabling static ORDER BY for a query
    List<Customer> findByLastNameOrderByFirstNameAsc(String lastname)
    List<Customer> findByLastNameOrderByFirstNameDesc(String lastname)

    List<Customer> findByAddressZipCode(int zipCode)
}