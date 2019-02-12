package com.prediction.tracker.predictionTracker.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngunawardena on 2/12/2019.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<SecurityContext> security = new ArrayList<SecurityContext>();
        security.add(securityContext());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                // The line below is used to avoid the basic-error-controller
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .pathMapping("/").securityContexts(security);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .forPaths(PathSelectors.regex("/"))
                .build();
    }

}
