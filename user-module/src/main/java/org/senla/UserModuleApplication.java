package org.senla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class UserModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserModuleApplication.class, args);
    }
}