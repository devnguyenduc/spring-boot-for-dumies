package com.a.o.shield.springbootfordummies.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.validation.annotation.Validated

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@ConstructorBinding
@ConfigurationProperties(prefix = "acme")
@Validated
class AcmeConfig {
    final boolean enabled
    final InetAddress remoteAddress
    final Security security

    AcmeConfig(boolean enabled, InetAddress remoteAddress, Security security) {
        this.enabled = enabled
        this.remoteAddress = remoteAddress
        this.security = security
    }

    static class Security {
        final String username
        final String password
        final List<String> roles

        Security(String username, String password, @DefaultValue("USER") List<String> roles) {
            this.username = username
            this.password = password
            this.roles = roles
        }
    }
}
