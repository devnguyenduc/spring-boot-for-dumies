package com.a.o.shield.springbootfordummies.repository

import com.a.o.shield.springbootfordummies.domain.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository extends CrudRepository<Address, Long> {
    Address findFirstByOrderById()
}