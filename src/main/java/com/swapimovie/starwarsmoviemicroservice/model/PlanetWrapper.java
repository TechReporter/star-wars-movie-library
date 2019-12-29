/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.model;

import java.util.List;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
public class PlanetWrapper {
	private int count;
	private String next;
	private List<?> results;

	public int getCount() { return this.count; }

	public void setCount(int count) { this.count = count; }

	public List<?> getResults() {
		return this.results; 
		}

	public void setResults(List<?> results) {
		this.results = results; 
		}


	public String getNext() {
		return next;
	}


	public void setNext(String next) {
		this.next = next;
	}
	
}
