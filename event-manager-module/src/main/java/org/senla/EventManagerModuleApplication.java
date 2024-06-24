package org.senla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EventManagerModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventManagerModuleApplication.class, args);
    }
}