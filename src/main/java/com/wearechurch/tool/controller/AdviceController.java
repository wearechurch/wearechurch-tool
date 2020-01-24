package com.wearechurch.tool.controller;

import java.net.ConnectException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.codec.CodecException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.client.WebClientResponseException.BadRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException.NotFound;

import com.wearechurch.tool.dto.Response;
import com.wearechurch.tool.enumerator.Reply;
import com.wearechurch.tool.exception.RarityException;

@ControllerAdvice
public class AdviceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdviceController.class);

	private static final ResponseEntity<Response> logResponse(final Exception exception, final Reply reply) {
		AdviceController.LOGGER.error("Code: {} | ClassName: {} | Message: {}", reply.getCode(),
				exception.getClass().getName(), exception.getLocalizedMessage());
		return ResponseEntity.ok(new Response(reply));
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<Response> bindException(final BindException exception) {
		return AdviceController.logResponse(exception, Reply.BIND);
	}

	@ExceptionHandler(CodecException.class)
	public ResponseEntity<Response> codecException(final CodecException exception) {
		return AdviceController.logResponse(exception, Reply.CODEC_CODEC);
	}

	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<Response> connectException(final ConnectException exception) {
		return AdviceController.logResponse(exception, Reply.NET_CONNECT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exception(final Exception exception) {
		return AdviceController.logResponse(exception, Reply.EXCEPTION);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Response> httpMessageNotReadableException(final HttpMessageNotReadableException exception) {
		return AdviceController.logResponse(exception, Reply.MESSAGE_READABLE);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public final ResponseEntity<Response> httpRequestMethodNotSupportedException(
			final HttpRequestMethodNotSupportedException exception) {
		return AdviceController.logResponse(exception, Reply.REQUEST_SUPPORTED);
	}

	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<Response> indexOutOfBoundsException(final IndexOutOfBoundsException exception) {
		return AdviceController.logResponse(exception, Reply.INDEX_BOUNDS);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response> methodArgumentNotValidException(final MethodArgumentNotValidException exception) {
		return AdviceController.logResponse(exception, Reply.METHOD_ARGUMENT);
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Response> numberFormatException(final NumberFormatException exception) {
		return AdviceController.logResponse(exception, Reply.NUMBER_FORMAT);
	}

	@ExceptionHandler(RarityException.class)
	public ResponseEntity<Response> rarityException(final RarityException exception) {
		return ResponseEntity.ok(new Response(exception.getReply()));
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Response> runtimeException(final RuntimeException exception) {
		return AdviceController.logResponse(exception, Reply.RUNTIME);
	}

	@ExceptionHandler({ BadRequest.class, NotFound.class, WebClientResponseException.class })
	public ResponseEntity<Response> webClientResponseException(final WebClientResponseException exception) {
		return AdviceController.logResponse(exception, Reply.CLIENT_RESPONSE);
	}

}