package com.a.o.shield.springbootfordummies.repository

import com.a.o.shield.springbootfordummies.domain.Customer
import org.springframework.data.repository.Repository

interface CustomerRepositoryWithLimitedResult extends Repository<Customer, Long> {
    Customer findFirstByOrderByAgeAsc()

    Optional<Customer> findTopByOrderByAgeDesc()

    List<Customer> queryFirst3ByAge(int age)

    List<Customer> findTop3ByLastName(String lastName)
    List<Customer> findFirst10ByLastName(String lastName)
    List<Customer> findTop10ByLastName(String lastName)
}