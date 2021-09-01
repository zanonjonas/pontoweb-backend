package br.com.zanonjonas.pontoweb.exception;

import org.springframework.http.HttpStatus;

public class EmptyIdHttpException extends PontoWebBaseHttpException {
	private static final long serialVersionUID = 812187168852703993L;
	
	private static final HttpStatus HTTP_STATUS_CODE = HttpStatus.BAD_REQUEST;

	public EmptyIdHttpException(String errorMessage) {
		super(errorMessage, HTTP_STATUS_CODE);
	}
	
 }
