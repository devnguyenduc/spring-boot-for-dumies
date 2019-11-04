package com.a.o.shield.springbootfordummies.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2)
class SecondCustomCommandLineRunner implements CommandLineRunner {
    @Override
    void run(String... args) throws Exception {
        println 'Second command line runner: '
        args.each {println it}
    }
}
