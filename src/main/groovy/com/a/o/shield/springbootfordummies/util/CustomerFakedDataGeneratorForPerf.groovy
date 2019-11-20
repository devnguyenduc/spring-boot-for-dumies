package com.a.o.shield.springbootfordummies.util

import com.a.o.shield.springbootfordummies.domain.Address
import com.a.o.shield.springbootfordummies.domain.Customer
import com.a.o.shield.springbootfordummies.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner

class CustomerFakedDataGeneratorForPerf implements CommandLineRunner {
    private static final int MAX = 1000

    @Autowired
    CustomerRepository repository

    @Override
    void run(String... args) throws Exception {
        (1..MAX).each {repository.save new Customer("Jack", "Bauer" + it, 9 + it, new Address(70000 + it))}
    }
}
