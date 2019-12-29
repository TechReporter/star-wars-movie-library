/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapimovie.starwarsmoviemicroservice.exception.NoSuchMovieInException;
import com.swapimovie.starwarsmoviemicroservice.model.MovieSearch;
import com.swapimovie.starwarsmoviemicroservice.model.People;
import com.swapimovie.starwarsmoviemicroservice.model.Planet;
import com.swapimovie.starwarsmoviemicroservice.model.PlanetWrapper;
import com.swapimovie.starwarsmoviemicroservice.util.StarWarsConstants;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
@Service
public class StarWarsServiceImpl implements StarWarsService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate restTemplate;

	public Planet getSwapiPlanetById(String id) {
		String movieUrl = StarWarsConstants.TYPE_URL + id;
		this.log.info("GET call " + movieUrl);
		Planet planet = this.restTemplate.getForObject(movieUrl, Planet.class);
		if(!Optional.ofNullable(planet).isPresent()) {
			throw new NoSuchMovieInException(101L, "No movie found");
		}
		return planet;
	}


	public MovieSearch findByTypeAndName(String type, String name) throws NoSuchMovieInException, RestClientException {
		String movieUrl = StarWarsConstants.BASE_URL + type + "?search=" + name;

		this.log.info("GET call " + movieUrl);

		MovieSearch swapiSearch = this.restTemplate.getForObject(movieUrl, MovieSearch.class, new Object[0]);
		swapiSearch.setType(type);

		if (swapiSearch.getCount().intValue() == 0) {
			throw new NoSuchMovieInException(101,"No movie present with name ::" + name);
		}
		return swapiSearch;
	}


	@Override
	public PlanetWrapper getSwapiAllPlanet(String name) throws NoSuchMovieInException {

		PlanetWrapper planet = new PlanetWrapper();
		List<Object> planetList = new ArrayList<>();

		String movieUrl = StarWarsConstants.BASE_URL + name;
		PlanetWrapper planetRes =  getPaginatedPlanetData(movieUrl);
		planetList.addAll(planetRes.getResults());
		int totalPlanet = planetRes.getCount();
		String planetResNxtUrl = planetRes.getNext();

		while(totalPlanet > planetList.size()) {
			PlanetWrapper planetRes_temp = getPaginatedPlanetData(planetResNxtUrl);
			planetList.addAll(planetRes_temp.getResults());
			planetResNxtUrl = planetRes_temp.getNext();
		}

		ObjectMapper mapper = new ObjectMapper();

		if(name.equals("planets")) {
			List<Planet> variable = mapper
					.convertValue(planetList, new TypeReference<List<Planet>>() {
					});
			planet.setResults(variable);
		}
		if(name.equals("people")) {
			List<People> variable = mapper
					.convertValue(planetList, new TypeReference<List<People>>() {
					});
			planet.setResults(variable);

		}
		planet.setCount(totalPlanet);

		System.out.println(planetList.size());
		return planet;
	}

	private PlanetWrapper getPaginatedPlanetData(String url) {
		return this.restTemplate.getForObject(url, PlanetWrapper.class);

	}
}
