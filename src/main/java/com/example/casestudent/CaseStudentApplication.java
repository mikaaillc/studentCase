package com.example.casestudent;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@OpenAPIDefinition
@SpringBootApplication
@Configuration
public class CaseStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudentApplication.class, args);
    }
    @Bean
    public OpenAPI customOpenAPI(@Value("case") String description,
                                 @Value("1.0") String version){
        return new OpenAPI()
                .info(new Info()
                        .title("case")
                        .version(version)
                        .description(description)
                        .license(new License().name("case")));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");

            }
        };
    }



}