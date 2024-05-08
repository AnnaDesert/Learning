package org.senla.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "org.senla.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Национальный сервис мониторинга цен на продовольственные товары(OpenAPI 3.0)")
                                .description("Национальный сервис мониторинга цен на продовольственные товары  Полезные ссылки: - [Репозиторий](https://github.com/AnnaDesert/Learning)")
                                .version("1.0.11")
                )
        ;
    }
}