package com.ssafy.happyhouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//3.0.0 http://localhost:9999/vuews/swagger-ui/index.html
//2.9.2 http://localhost:9999/vuews/swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		final ApiInfo apiInfo=new ApiInfoBuilder()
				.title("SSAFY API")
				.description("<h2>SSAFY VUE happyhouse WorkShop API Reference for Developers</h2>")
				.termsOfServiceUrl("https://edu.ssafy.com")
				.license("SSAFY License")
				.licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp")
				.version("5.0").build();
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("ssafyHappyhouseVue")
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/*/happyhouse/**").or(PathSelectors.ant("/*/notice/**")).or(PathSelectors.ant("/*/qna/**")).or(PathSelectors.ant("/*/user/**")).or(PathSelectors.ant("/*/search/**")).or(PathSelectors.ant("/*/comment/**")).or(PathSelectors.ant("/*/myapi/**")).or(PathSelectors.ant("/*/review/**")))
				.build();
	}
}
