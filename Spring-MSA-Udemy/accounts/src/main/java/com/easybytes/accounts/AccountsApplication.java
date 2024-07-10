package com.easybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                description = "Easy Bank Accounts microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Jeseo",
                        email = "Jeseo@test.com",
                        url = "https://www.naver.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.tistory.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Easy Bank Accounts microservice REST API Documentation",
                url = "https://www.eazybytes.com"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
