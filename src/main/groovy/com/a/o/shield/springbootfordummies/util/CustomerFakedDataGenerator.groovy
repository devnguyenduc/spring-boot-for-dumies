package com.a.o.shield.springbootfordummies.accessingdatajpa

import com.a.o.shield.springbootfordummies.domain.Address
import com.a.o.shield.springbootfordummies.domain.Customer
import com.a.o.shield.springbootfordummies.domain.Type
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
    CustomerRepository repository

    @Override
    void run(String... args) throws Exception {
        repository.save new Customer("Jack", "Bauer", 19, new Address(street: "To Ky", zipCode: 70000), Type.PLATINUM)
        repository.save new Customer("Chloe", "O'Brian", 33, new Address(street: "To Ky", zipCode:  34675))
        repository.save new Customer("Kim", "Bauer", 56, new Address(89674))
        repository.save new Customer("David", "Palmer", 18, new Address(23619))
        repository.save new Customer("Michelle", "Dessler", 9, new Address(70000), Type.GOLD)
        /*def dummyAddress = new Address(custom_id: 10, street: "To Ky", zipCode: 70000)
        repository.save new Customer("Jack", "Bauer", 19, dummyAddress, Type.PLATINUM)
        repository.save new Customer("Chloe", "O'Brian", 33, dummyAddress)
        repository.save new Customer("Kim", "Bauer", 56, dummyAddress)
        repository.save new Customer("David", "Palmer", 18, dummyAddress)
        repository.save new Customer("Michelle", "Dessler", 9, dummyAddress, Type.GOLD)*/
    }
}
