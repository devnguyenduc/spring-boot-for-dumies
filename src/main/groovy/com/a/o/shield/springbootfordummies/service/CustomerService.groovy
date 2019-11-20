package com.a.o.shield.springbootfordummies.service

import com.a.o.shield.springbootfordummies.domain.Customer
import com.a.o.shield.springbootfordummies.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service

import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

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

    private static class CustomerSpecification implements Specification<Customer> {
        private final Optional<Integer> age
        private final Optional<String> firstName

        CustomerSpecification(Optional<Integer> age, Optional<String> firstName) {
            this.age = age
            this.firstName = firstName
        }

        @Override
        Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicates = []

            age.map({int givenAge ->
                predicates << criteriaBuilder.greaterThan(root.get('age'), givenAge)
            })

            firstName.map({String givenFirstName ->
                predicates << criteriaBuilder.equal(root.get('firstName'), givenFirstName)
            })

            criteriaBuilder & (predicates as Predicate[])
        }
    }
}
