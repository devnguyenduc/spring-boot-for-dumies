package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.springframework.data.repository.CrudRepository

interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName)
    Customer findById(long id)
}
