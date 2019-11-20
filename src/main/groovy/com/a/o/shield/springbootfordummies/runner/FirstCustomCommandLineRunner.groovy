package com.a.o.shield.springbootfordummies.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


class FirstCustomCommandLineRunner implements CommandLineRunner {

    @Override
    void run(String... args) throws Exception {
        println 'First order command line: '
        args.each {println it}
    }
}
