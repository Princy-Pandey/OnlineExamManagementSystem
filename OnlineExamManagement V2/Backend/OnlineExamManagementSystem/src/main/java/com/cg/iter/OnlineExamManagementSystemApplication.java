package com.cg.iter;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author ShirshakPanda
 *
 */
@EnableSwagger2
@SpringBootApplication
public class OnlineExamManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExamManagementSystemApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.build()
		.apiInfo(appDetails());
	}
	private ApiInfo appDetails(){
		return new ApiInfo("Online Exam Management System","Questions Module","1.0","free to use", new springfox.documentation.service.Contact("SHIRSHAK PANDA","","shirshakme@gmail.com"),"","",Collections.emptyList());

	
	}
}
