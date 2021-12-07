package com.services.turiscamp.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.services.turiscamp.controller"))
	                .paths(PathSelectors.any())
	                .build().apiInfo(metaData());
	    }

	    private ApiInfo metaData() {
	        return new ApiInfoBuilder()
	                .title("Documentación API | Turiscamp")
	                .description("Turiscamp 2021")
	                .version("1.0.0")
	                .license("Apache 2.0")
	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
	                .contact(new Contact("Gabriel Juarez", "Turiscamp","gabriel.juarez@turiscamp.mx"))
	                .build();
	    }
	    
	

}
