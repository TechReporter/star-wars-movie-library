/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
public class MovieType {
	private String name;
	@JsonProperty("films")
	private String[] films;
	@JsonPropertyDescription("residents url define")
	@JsonProperty("residents")
	public String[] residentsUrls;


	public String[] getFilms() { return this.films; }



	public void setFilms(String[] films) { this.films = films; }



	public String getName() { return this.name; }



	public void setName(String name) { this.name = name; }


	public String[] getResidentsUrls() {
		return residentsUrls;
	}


	public void setResidentsUrls(String[] residentsUrls) {
		this.residentsUrls = residentsUrls;
	}

	public int getApparitionsCount() {
		if (this.films == null) {
			return 0;
		}
		return this.films.length;
	}
	
	public int getResidentCount() {
		if(residentsUrls.length == 0)
			return 0;
		return this.residentsUrls.length;
	}
}
