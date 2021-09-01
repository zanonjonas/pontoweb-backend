package br.com.zanonjonas.pontoweb.exception;

import org.springframework.http.HttpStatus;

abstract class PontoWebBaseHttpException extends Exception {
	public final HttpStatus httpStatus;
	
	public PontoWebBaseHttpException(String messageError, HttpStatus httpStatus) {
		super(messageError);
		this.httpStatus = httpStatus;
	}
	
}
