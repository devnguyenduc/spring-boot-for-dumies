package com.a.o.shield.springbootfordummies.accessingdatajpa

import com.a.o.shield.springbootfordummies.domain.Address
import com.a.o.shield.springbootfordummies.domain.Customer
import com.a.o.shield.springbootfordummies.repository.CustomerPageableAndSortable
import com.a.o.shield.springbootfordummies.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class CustomerFakedDataGeneratorForPerf implements CommandLineRunner {
    private static final def log = LoggerFactory.getLogger CustomerFakedDataGeneratorForPerf.class
    private static final int MAX = 1000

    @Autowired
    CustomerRepository repository

    @Autowired
    CustomerPageableAndSortable pageableAndSortable

    @Override
    void run(String... args) throws Exception {
        (1..MAX).each {repository.save new Customer("Jack", "Bauer" + it, 9 + it, new Address(70000 + it))}

        Pageable pageRequest =  PageRequest.of(0, 10)
        CustomerSpecification customerSpecification = new CustomerSpecification(19, 'Jack')

        PageImpl<Customer> customers = new PageImpl<>([], pageRequest, 0)
        customers = pageableAndSortable.findAll(customerSpecification, pageRequest)

        log.info customers.size.toString()
    }
}
