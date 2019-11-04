package com.a.o.shield.springbootfordummies.runner

import com.a.o.shield.springbootfordummies.config.ServerConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CustomConfigRunner implements CommandLineRunner {

    @Autowired
    private ServerConfig serverConfig

    @Override
    void run(String... args) throws Exception {
        println "Custom configuration: " + serverConfig.servers
    }
}
