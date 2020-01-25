package com.wearechurch.tool.controller;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.wearechurch.tool.configuration.Properties;
import com.wearechurch.tool.dto.Response;
import com.wearechurch.tool.enumerator.Reply;
import com.wearechurch.tool.exception.RarityException;

import io.netty.handler.ssl.NotSslRecordException;
import reactor.netty.http.client.PrematureCloseException;

@ControllerAdvice
public class AdviceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdviceController.class);

	@Autowired
	private Properties properties;

	@ExceptionHandler(BindException.class)
	public ResponseEntity<Response> bindException(final BindException exception) {
		return buildResponse(exception, Reply.BIND);
	}

	private final ResponseEntity<Response> buildResponse(final Exception exception, final Reply reply) {
		AdviceController.LOGGER.error("Code: {} | ClassName: {} | Message: {}", reply.getCode(),
				exception.getClass().getName(), exception.getLocalizedMessage());
		final Response response = new Response(reply);
		response.setApplication(properties.getSpringApplicationName());
		return ResponseEntity.ok(response);
	}

	@ExceptionHandler(CodecException.class)
	public ResponseEntity<Response> codecException(final CodecException exception) {
		return buildResponse(exception, Reply.CODEC);
	}

	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<Response> connectException(final ConnectException exception) {
		return buildResponse(exception, Reply.CONNECT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exception(final Exception exception) {
		return buildResponse(exception, Reply.EXCEPTION);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Response> httpMessageNotReadableException(final HttpMessageNotReadableException exception) {
		return buildResponse(exception, Reply.MESSAGE_READABLE);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public final ResponseEntity<Response> httpRequestMethodNotSupportedException(
			final HttpRequestMethodNotSupportedException exception) {
		return buildResponse(exception, Reply.REQUEST_SUPPORTED);
	}

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<Response> illegalStateException(final IllegalStateException exception) {
		return buildResponse(exception, Reply.ILLEGAL_STATE);
	}

	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<Response> indexOutOfBoundsException(final IndexOutOfBoundsException exception) {
		return buildResponse(exception, Reply.INDEX_BOUNDS);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response> methodArgumentNotValidException(final MethodArgumentNotValidException exception) {
		return buildResponse(exception, Reply.METHOD_ARGUMENT);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Response> noSuchElementException(final NoSuchElementException exception) {
		return buildResponse(exception, Reply.SUCH_ELEMENT);
	}

	@ExceptionHandler(NotSslRecordException.class)
	public ResponseEntity<Response> notSslRecordException(final NotSslRecordException exception) {
		return buildResponse(exception, Reply.SSL_RECORD);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Response> nullPointerException(final NullPointerException exception) {
		return buildResponse(exception, Reply.NULL_POINTER);
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Response> numberFormatException(final NumberFormatException exception) {
		return buildResponse(exception, Reply.NUMBER_FORMAT);
	}

	@ExceptionHandler(PrematureCloseException.class)
	public ResponseEntity<Response> prematureCloseException(final PrematureCloseException exception) {
		return buildResponse(exception, Reply.PREMATURE_CLOSE);
	}

	@ExceptionHandler(RarityException.class)
	public ResponseEntity<Response> rarityException(final RarityException exception) {
		return buildResponse(exception, exception.getReply());
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Response> runtimeException(final RuntimeException exception) {
		return buildResponse(exception, Reply.RUNTIME);
	}

	@ExceptionHandler(UnknownHostException.class)
	public ResponseEntity<Response> unknownHostException(final UnknownHostException exception) {
		return buildResponse(exception, Reply.UNKNOWN_HOST);
	}

	@ExceptionHandler({ BadRequest.class, NotFound.class, WebClientResponseException.class })
	public ResponseEntity<Response> webClientResponseException(final WebClientResponseException exception) {
		return buildResponse(exception, Reply.CLIENT_RESPONSE);
	}

}