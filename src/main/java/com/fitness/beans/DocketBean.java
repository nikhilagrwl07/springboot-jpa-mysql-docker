package com.fitness.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;

/**
 * Created by nikhilagrawal on 09/02/18.
 */

@Configuration
@EnableSwagger2
public class DocketBean {
    private static final HashSet<String> DEFAULT_CONSUME_PRODUCE_TYPE = new HashSet<String>() {{
        add("application/json");
        add("application/xml");
    }};


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(DEFAULT_CONSUME_PRODUCE_TYPE)
                .consumes(DEFAULT_CONSUME_PRODUCE_TYPE)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Gym Simulation")
                .description("Gym Simulation based on microservice architecture")
                .version("1.0")
                .termsOfServiceUrl("http://terms-of-services.url")
                .license("LICENSE")
                .licenseUrl("http://url-to-license.com")
                .build();
    }
}
