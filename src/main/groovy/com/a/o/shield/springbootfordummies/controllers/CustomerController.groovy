package com.a.o.shield.springbootfordummies.controllers

import com.a.o.shield.springbootfordummies.accessingdatajpa.Customer
import com.a.o.shield.springbootfordummies.accessingdatajpa.CustomerRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/customer')
class CustomerController {
    private static final Logger LOG = LoggerFactory.getLogger CustomerController.class
    private static final String DEFAULT_SORT = '+lastName'

    @Autowired
    CustomerRepository repository

    @GetMapping
    Iterable<Customer> getAll(@RequestParam(value = 'sort', required = false) String sort) {
        String sortParam = sort ?: DEFAULT_SORT
        LOG.info "Got getAll request sorting by $sortParam"
        Sort.TypedSort<Customer> customerTypedSort = Sort.sort(Customer.class)
        repository.findAll(customerTypedSort.by(sortParam).ascending())
    }

    @PostMapping
    Customer save(@RequestBody Customer customer) {
        repository.save(customer)
    }
}
