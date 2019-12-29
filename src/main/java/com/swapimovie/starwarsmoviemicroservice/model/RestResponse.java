/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.model;

import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author 212720190
 * @date Jul 25, 2019
 */
public class RestResponse<T> {

	private T data;
	private String error;
	private HttpStatus code;
	
	public RestResponse(T data, String errors, HttpStatus code) {
		this.data = data;
		this.error = errors;
		this.code = code;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setErrors(String error) {
		this.error = error;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

}
