package com.swapimovie.starwarsmoviemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(value = {
		StarWarsMovieMicroserviceApplication.class
})
@EnableAutoConfiguration
public class StarWarsMovieMicroserviceApplicationTests extends StarWarsMovieMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StarWarsMovieMicroserviceApplication.class, args);
	}
}
