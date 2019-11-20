package com.a.o.shield.springbootfordummies.util

import com.a.o.shield.springbootfordummies.domain.Address
import com.a.o.shield.springbootfordummies.domain.Customer
import com.a.o.shield.springbootfordummies.domain.Type
import com.a.o.shield.springbootfordummies.repository.AddressRepository
import com.a.o.shield.springbootfordummies.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Order(3)
@Component
class CustomerFakedDataGenerator implements CommandLineRunner {
    private static final def log = LoggerFactory.getLogger CustomerFakedDataGenerator.class

    @Autowired
    CustomerRepository customerRepository

    @Autowired
    AddressRepository addressRepository

    @Override
    void run(String... args) throws Exception {
        Address address = addressRepository.findFirstByOrderById()
        customerRepository.save new Customer("Jack", "Bauer", 19, address, Type.PLATINUM)
        customerRepository.save new Customer("Chloe", "O'Brian", 33, address)
        customerRepository.save new Customer("Kim", "Bauer", 56, address)
        customerRepository.save new Customer("David", "Palmer", 18, address)
        customerRepository.save new Customer("Michelle", "Dessler", 9, address, Type.GOLD)
    }
}
