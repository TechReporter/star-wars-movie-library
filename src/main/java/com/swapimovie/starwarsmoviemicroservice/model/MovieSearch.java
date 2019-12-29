/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.model;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
public class MovieSearch {
	private Integer count;
	  private String type;
	  private MovieType[] results;
	  
	  public Integer getCount() { return this.count; }


	  
	  public void setCount(Integer count) { this.count = count; }


	  
	  public MovieType[] getResults() { return this.results; }


	  
	  public void setResults(MovieType[] swPlanets) { this.results = swPlanets; }


	  
	  public String getType() { return this.type; }


	  
	  public void setType(String type) { this.type = type; }
}
