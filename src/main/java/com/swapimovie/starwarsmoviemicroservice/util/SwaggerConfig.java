/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swagApi() { return (new Docket(DocumentationType.SWAGGER_2)).select()
			.apis(RequestHandlerSelectors.basePackage("com.swapimovie.starwarsmoviemicroservice"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(otherInfo()); }




	private ApiInfo otherInfo() { return (new ApiInfoBuilder()).title("star wars REST swagger documentation")
			.description("demp implementation of swagger")
			.contact("Tanmoy Dasgupta, +91-999999999").termsOfServiceUrl("www.anonymous.com").build(); }
}
