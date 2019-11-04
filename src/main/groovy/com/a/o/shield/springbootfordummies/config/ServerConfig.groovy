package com.a.o.shield.springbootfordummies.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "custom")
class ServerConfig {

    private List<String> servers = new ArrayList<String>()

    List<String> getServers() {
        this.servers
    }
}
