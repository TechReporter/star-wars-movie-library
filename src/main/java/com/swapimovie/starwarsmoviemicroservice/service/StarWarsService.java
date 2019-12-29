/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.service;

import com.swapimovie.starwarsmoviemicroservice.exception.NoSuchMovieInException;
import com.swapimovie.starwarsmoviemicroservice.model.MovieSearch;
import com.swapimovie.starwarsmoviemicroservice.model.Planet;
import com.swapimovie.starwarsmoviemicroservice.model.PlanetWrapper;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
public interface StarWarsService {
	Planet getSwapiPlanetById(String paramString);

	MovieSearch findByTypeAndName(String paramString1, String paramString2) throws NoSuchMovieInException;

	PlanetWrapper getSwapiAllPlanet(String paramString) throws NoSuchMovieInException;
}
