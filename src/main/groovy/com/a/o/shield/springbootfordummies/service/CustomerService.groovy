package com.a.o.shield.springbootfordummies.service

import com.a.o.shield.springbootfordummies.accessingdatajpa.Customer
import com.a.o.shield.springbootfordummies.accessingdatajpa.CustomerRepository
import com.a.o.shield.springbootfordummies.accessingdatajpa.CustomerSpecification
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class CustomerService {
    private static final LOG = LoggerFactory.getLogger CustomerService.class
    private static final DEFAULT_TOTAL_IN_PAGE_REQUEST = 0

    @Autowired
    CustomerRepository customerRepository

    PageImpl<Customer> getCustomers(PageRequest pageRequest, Optional<Integer> age, Optional<String> firstName) {
        PageImpl<Customer> customers = new PageImpl<>([], pageRequest, DEFAULT_TOTAL_IN_PAGE_REQUEST)

        CustomerSpecification customerSpecification = new CustomerSpecification(age, firstName)
        customers = customerRepository.findAll(customerSpecification, pageRequest)
        LOG.info("Got ${customers.size} customers")
        customers
    }
}
