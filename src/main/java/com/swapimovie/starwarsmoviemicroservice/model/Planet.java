/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
@JsonIgnoreProperties(ignoreUnknown=true)

public class Planet implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public String diameter;
	public String gravity;
	public String population;
	public String climate;
	public String terrain;
	public String url;
	@JsonProperty("rotation_period")
	public String rotationPeriod;
	@JsonProperty("orbital_period")
	public String orbitalPeriod;
	@JsonProperty("surface_water")
	public String surfaceWater;
	@JsonProperty("residents")
	public List<String> residentsUrls;
	@JsonProperty("films")
	public List<String> filmsUrls;

	public int getFilmCount() {
		if(filmsUrls.isEmpty())
			return 0;
		return this.filmsUrls.size();
	}

	public int getResidentCount() {
		if(residentsUrls.isEmpty())
			return 0;
		return this.residentsUrls.size();
	}

	public String toString() { return "Planet [name=" + this.name + ", diameter=" + this.diameter + ", gravity=" + this.gravity + ", population=" + this.population + ", climate=" + this.climate + ", terrain=" + this.terrain + ", url=" + this.url + ", rotationPeriod=" + this.rotationPeriod + ", orbitalPeriod=" + this.orbitalPeriod + ", surfaceWater=" + this.surfaceWater + ", residentsUrls=" + this.residentsUrls + ", filmsUrls=" + this.filmsUrls + "]"; }

}