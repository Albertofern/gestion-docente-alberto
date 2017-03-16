package com.ipartek.formacion.api.restfulservers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean // dotamos al metodo como un objeto y cuando despliega la apilicacion usara el ApiInfo
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.ipartek.formacion.api.restfulservers"))
                .paths(PathSelectors.any()).build(); // Aqui: podriamos filtrar la documentacion
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("TITLE").description("DESCRIPTION").version("VERSION")
                .termsOfServiceUrl("http://terms-of-services.url").license("LICENSE")
                .licenseUrl("http://url-to-license.com").build();
    }
	
}
