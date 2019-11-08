package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.springframework.data.repository.PagingAndSortingRepository

interface CustomerPageableAndSortable extends PagingAndSortingRepository<Customer, Long> {
    long countByLastName(String lastName)
    long deleteByLastName(String lastName)
    List<Customer> removeByLastName(String lastName)
}