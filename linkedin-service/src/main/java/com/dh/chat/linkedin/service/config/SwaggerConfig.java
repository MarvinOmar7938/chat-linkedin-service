package com.dh.chat.linkedin.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Santiago Mamani
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("linkedin-api")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.dh.chat.linkedin.service.controller.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket system() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("system-api")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.dh.chat.linkedin.service.controller.system"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder()
                .title("linkedin Service API")
                .description("linkedin Management REST API ")
                .contact(new Contact("marvin", "", "mtolapacheco@gmail.com"))
                .version("0.0.2")
                .license("Apache 1.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
