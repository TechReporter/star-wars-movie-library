/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 212720190
 * @date Jul 24, 2019
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoSuchMovieInException extends MovieException {

	private static final long serialVersionUID = 1L;

	public NoSuchMovieInException(long errorCode,String message) {
		super(errorCode,message);
	}
	
	public NoSuchMovieInException(long errorCode, String errorDesc, Throwable cause,String message) {
		super(errorCode, errorDesc,cause,message);
	}
}