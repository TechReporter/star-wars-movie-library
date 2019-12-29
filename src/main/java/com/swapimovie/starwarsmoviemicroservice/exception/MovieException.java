/**
 * 
 */
package com.swapimovie.starwarsmoviemicroservice.exception;

/**
 * @author 212720190
 * @date Dec 28, 2019
 */
public class MovieException extends RuntimeException {

	private static final long serialVersionUID = -1074795838766729803L;

	private final  long errorCode;
	private final  String errorDesc;
	
	public MovieException(long errorCode, String errorDesc) {
  		super();
  		this.errorCode = errorCode;
  		this.errorDesc = errorDesc;
  	}
	
  	public MovieException(long errorCode, String errorDesc, Throwable cause,String message) {
  		super(message,cause);
  		this.errorCode = errorCode;
  		this.errorDesc = errorDesc;
  	}
	public long getErrorCode() {
		return errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}
}
