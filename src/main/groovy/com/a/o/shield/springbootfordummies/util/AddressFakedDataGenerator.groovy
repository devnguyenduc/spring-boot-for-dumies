package com.a.o.shield.springbootfordummies.util

import com.a.o.shield.springbootfordummies.domain.Address
import com.a.o.shield.springbootfordummies.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2)
class AddressFakedDataGenerator implements CommandLineRunner {
    @Autowired
    AddressRepository addressRepository

    @Override
    void run(String... args) throws Exception {
        addressRepository.save new Address(street: "To Ky", zipCode: 70000)
        addressRepository.save new Address(street: "Cong Hoa", zipCode: 70000)
        addressRepository.save new Address(street: "Pham Van Chieu", zipCode: 70000)
        addressRepository.save new Address(street: "Quang Trung", zipCode: 70000)
        addressRepository.save new Address(street: "Le Van Tho", zipCode: 70000)
    }
}
