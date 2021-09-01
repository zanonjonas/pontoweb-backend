package br.com.zanonjonas.pontoweb.exception;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * Provides handling for exceptions throughout this service.
	 *
	 * @param ex      The target exception
	 * @param request The current request
	 */
	@ExceptionHandler({ PontoWebBaseHttpException.class, EmptyIdHttpException.class, UserNotFoundHttpException.class })
	@Nullable
	public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		LOGGER.error("Handling " + ex.getClass().getSimpleName() + " due to " + ex.getMessage());

		if (ex instanceof PontoWebBaseHttpException) {
			return handleMappedExceptions((PontoWebBaseHttpException) ex, headers, request);

		} else {
			if (LOGGER.isWarnEnabled()) {
				LOGGER.warn("Unknown exception type: " + ex.getClass().getName());
			}

			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);
		}
	}

	protected ResponseEntity<ApiError> handleMappedExceptions(PontoWebBaseHttpException ex, HttpHeaders headers,
			WebRequest request) {
		List<String> errors = Collections.singletonList(ex.getMessage());
		return handleExceptionInternal(ex, new ApiError(errors), headers, ex.httpStatus, request);
	}

	protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, @Nullable ApiError body,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<>(body, headers, status);
	}
}
