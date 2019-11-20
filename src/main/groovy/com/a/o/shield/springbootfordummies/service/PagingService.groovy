package com.a.o.shield.springbootfordummies.service

import com.a.o.shield.springbootfordummies.accessingdatajpa.Customer
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class PagingService {
    private static final LOG = LoggerFactory.getLogger PagingService.class
    private static final DEFAULT_SORT = 'lastName'
    private static final DEFAULT_PAGE_NUMBER = 0
    private static final DEFAULT_PAGE_SIZE = 3

    Pageable createPagingRequest(String sortProperty, Integer pageNumber, Integer pageSize) {
        String sortParam = sortProperty ?: DEFAULT_SORT
        int givenPageNumber = pageNumber ? pageNumber - 1 : DEFAULT_PAGE_NUMBER
        int givenPageSize = pageSize ?: DEFAULT_PAGE_SIZE
        LOG.info "Got getAll request sorting by $sortParam"

        Sort.TypedSort<Customer> customerTypedSort = Sort.sort(Customer.class)

        PageRequest.of(givenPageNumber, givenPageSize, customerTypedSort.by(sortParam))
    }
}
