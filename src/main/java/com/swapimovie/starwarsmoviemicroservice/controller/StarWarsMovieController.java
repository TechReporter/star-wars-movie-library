/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.swapimovie.starwarsmoviemicroservice.exception.NoSuchMovieInException;
import com.swapimovie.starwarsmoviemicroservice.model.MovieSearch;
import com.swapimovie.starwarsmoviemicroservice.model.Planet;
import com.swapimovie.starwarsmoviemicroservice.model.PlanetWrapper;
import com.swapimovie.starwarsmoviemicroservice.model.RestResponse;
import com.swapimovie.starwarsmoviemicroservice.service.StarWarsService;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
@RestController
@RequestMapping(value="/starwars")
@CrossOrigin
public class StarWarsMovieController {

	@Autowired
	private StarWarsService starWarsService;

	@GetMapping(value = "/planets/{id}")
	Planet findById(@PathVariable String id) throws NoSuchMovieInException {
		return this.starWarsService.getSwapiPlanetById(id); 
	}

	@GetMapping(path = "/movies")
	MovieSearch findByTypeAndName(@RequestParam(name = "type", required = true) String type,
			@RequestParam(name = "name", required = true) String name) throws NoSuchMovieInException {
		return this.starWarsService.findByTypeAndName(type, name); 
	}

	@GetMapping(value = {"/allplanets/{name}"})
	ResponseEntity<RestResponse<PlanetWrapper>> getAllPlanets(@PathVariable String name) throws RestClientException, NoSuchMovieInException {
		RestResponse<PlanetWrapper> response = null;
		
		if(Optional.ofNullable(this.starWarsService.getSwapiAllPlanet(name)).isPresent()) {
			response = new RestResponse<>(this.starWarsService.getSwapiAllPlanet(name),
					null, HttpStatus.OK);
			return ResponseEntity.ok(response);
		} else {
			response = new RestResponse<>(null,
					"No Data available", HttpStatus.NO_CONTENT);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}

	}
}