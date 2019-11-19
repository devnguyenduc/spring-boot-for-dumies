package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

interface CustomerPageableAndSortable extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    long countByLastName(String lastName)
    long deleteByLastName(String lastName)
    List<Customer> removeByLastName(String lastName)

    PageImpl<Customer> findAll(Specification<Customer> customerSpecification, Pageable pageRequest)
}