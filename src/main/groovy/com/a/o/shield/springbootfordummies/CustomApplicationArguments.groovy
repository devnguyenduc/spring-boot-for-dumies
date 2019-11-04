package com.a.o.shield.springbootfordummies

import org.springframework.boot.ApplicationArguments
import org.springframework.stereotype.Component

@Component
class CustomApplicationArguments {
    CustomApplicationArguments(ApplicationArguments givenArgs) {
        println givenArgs.properties
    }
}
