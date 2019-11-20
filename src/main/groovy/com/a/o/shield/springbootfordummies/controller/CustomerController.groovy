package com.a.o.shield.springbootfordummies.controller

import com.a.o.shield.springbootfordummies.domain.Customer
import com.a.o.shield.springbootfordummies.service.CustomerService
import com.a.o.shield.springbootfordummies.service.PagingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/customer')
class CustomerController {
    @Autowired
    CustomerService customerService

    @Autowired
    PagingService pagingService

    @GetMapping
    Iterable<Customer> getAll(@RequestParam(value = 'sort', required = false) String sort,
                              @RequestParam(value = 'page', required = false) Integer page,
                              @RequestParam(value = 'pageSize', required = false) Integer pageSize,
                              @RequestParam(value = 'age') Integer age,
                              @RequestParam(value = 'firstName', required = false) Optional<String> firstName) {
        PageRequest pageRequest = pagingService.createPagingRequest(sort, page, pageSize)
        Date latestVisitedTime = customerService.latestVisitedTime
        customerService.getCustomers(pageRequest, age, firstName, latestVisitedTime)
    }

    @GetMapping('latest')
    Date getLatestVisitedTime() {
        customerService.getLatestVisitedTime()
    }
}
