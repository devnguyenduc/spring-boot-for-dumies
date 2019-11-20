package com.a.o.shield.springbootfordummies.repository

import com.a.o.shield.springbootfordummies.domain.Customer
import com.a.o.shield.springbootfordummies.domain.Type
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.repository.CrudRepository

interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName)
    List<Customer> findByType(Type type)
    Customer findById(long id)

    PageImpl<Customer> findAll(Specification<Customer> specification, Pageable pagingRequest)
    Customer findFirstByOrderByLastVisited()
}
