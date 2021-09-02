package br.com.zanonjonas.pontoweb.exception;

import org.springframework.http.HttpStatus;

public class NotFoundHttpException extends PontoWebBaseHttpException {
	private static final long serialVersionUID = -7771713186516321863L;
	
	private static final HttpStatus HTTP_STATUS_CODE = HttpStatus.NOT_FOUND;

	public NotFoundHttpException(String message) {
		super(message, HTTP_STATUS_CODE);
		// TODO Auto-generated constructor stub
	}
}
