package com.a.o.shield.springbootfordummies.service

import com.a.o.shield.springbootfordummies.config.AcmeConfig
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
class AcmeService {
    private final AcmeConfig acmeConfig

    AcmeService(final AcmeConfig acmeConfig) {
        this.acmeConfig = acmeConfig
    }

    @PostConstruct
    void openConnection() {
        println "Initialize the acme connection using acme configuration"
        acmeConfig.properties.each {println it}
    }
}
