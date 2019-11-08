package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataGeneratorRunner implements CommandLineRunner {
    private static final def log = LoggerFactory.getLogger DataGeneratorRunner.class

    @Autowired
    CustomerRepository repository

    @Override
    void run(String... args) throws Exception {
        repository.save new Customer("Jack", "Bauer")
        repository.save new Customer("Chloe", "O'Brian")
        repository.save new Customer("Kim", "Bauer")
        repository.save new Customer("David", "Palmer")
        repository.save new Customer("Michelle", "Dessler")

        // fetch all customers
        log.info "Customers found with findAll():"
        log.info "-------------------------------"

        def customers = repository.findAll()

        customers.each {log.info it?.toString()}

        log.info ""

        // fetch an individual customer by ID
        Customer customer = repository.findById 1L
        log.info "Customer found with findById(1L):"
        log.info "--------------------------------"
        log.info customer?.toString()
        log.info ""

        // fetch customers by last name
        log.info "Customer found with findByLastName('Bauer'):"
        log.info "--------------------------------------------"
        repository.findByLastName("Bauer").each {log.info it?.toString()}

        log.info ""
    }
}
