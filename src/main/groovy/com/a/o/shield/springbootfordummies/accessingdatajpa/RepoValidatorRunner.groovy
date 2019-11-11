package com.a.o.shield.springbootfordummies.accessingdatajpa

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class RepoValidatorRunner implements CommandLineRunner {
    private static final def log = LoggerFactory.getLogger RepoValidatorRunner.class

    @Autowired
    CustomerRepository repository
    @Autowired
    CustomerPageableAndSortable pageableAndSortable
    @Autowired
    CustomerGenericRepository genericRepository

    @Override
    void run(String... args) throws Exception {
        repository.save new Customer("Jack", "Bauer", 19, new Address(70000))
        repository.save new Customer("Chloe", "O'Brian", 33, new Address(34675))
        repository.save new Customer("Kim", "Bauer", 56, new Address(89674))
        repository.save new Customer("David", "Palmer", 18, new Address(23619))
        repository.save new Customer("Michelle", "Dessler", 9, new Address(70000))

        // fetch all customers
        log.info "Customers found with findAll():"
        log.info "-------------------------------"

        def customers = repository.findAll()

        customers.each {log.info it.toString()}

        log.info "Customer in the sort fashion"
        Sort.TypedSort<Customer> customerTypedSort = Sort.sort(Customer.class)
        repository.findAll(customerTypedSort.by("age").ascending()).each {log.info it.toString()}

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
        repository.findByLastName("Bauer").each {log.info it.toString()}

        log.info "Started using pageable/sortable repository"
        log.info "Find all in page 1"
        pageableAndSortable.findAll(PageRequest.of(0, 2)).each {log.info it.toString()}

        def count = pageableAndSortable.countByLastName "Bauer"
        log.info "Customer countByLastName('Bauer'): " + count

        log.info "Started using generic repository"
        log.info "findByEmailAddressAndLastname('jackbauer', 'bauer')"
        genericRepository.findByEmailAddressAndLastName('jackbauer', 'Bauer').each {log.info it.toString()}
        log.info "findByAddressZipCode(70000)"
        genericRepository.findByAddressZipCode(70000).each {log.info it.toString()}
        log.info ""
    }
}
