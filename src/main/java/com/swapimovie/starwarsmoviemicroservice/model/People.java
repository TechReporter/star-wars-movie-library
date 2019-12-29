/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 212720190
 * @date Jul 25, 2019
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class People implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String name;
	public String height;
	public String mass;
	@JsonProperty("hair_color")
	private String hairColor;
	@JsonProperty("skin_color")
	private String skinColor;
	@JsonProperty("eye_color")
	private String eyeColor;
	@JsonProperty("birth_year")
	private String birthYear;
	public String gender;
	@JsonProperty("films")
	private String[] filmsUrl;
	@JsonProperty("species")
	private String[] speciesUrl;
	@JsonProperty("vehicles")
	private String[] vehiclesUrl;
	@JsonProperty("starships")
	private String[] starshipsUrl;

	public int getFilmsCount() {
		if(filmsUrl.length == 0)
			return 0;
		return this.filmsUrl.length;
	}
	
	public int getSpeciesCount() {
		if(speciesUrl.length == 0)
			return 0;
		return this.speciesUrl.length;
	}

	public int getVehiclesCount() {
		if(vehiclesUrl.length == 0)
			return 0;
		return this.vehiclesUrl.length;
	}
	
	public int getStarshipsCount() {
		if(starshipsUrl.length == 0)
			return 0;
		return this.starshipsUrl.length;
	}
}
