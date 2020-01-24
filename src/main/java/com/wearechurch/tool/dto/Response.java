package com.wearechurch.tool.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wearechurch.tool.enumerator.Reply;

@JsonInclude(value = Include.NON_EMPTY)
public class Response {
	private Integer code;
	private String application;
	private String message;

	public Response() {
	}

	public Response(final Reply reply) {
		code = reply.getCode();
		message = reply.getMessage();
	}

	public String getApplication() {
		return application;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setApplication(final String application) {
		this.application = application;
	}

	public void setCode(final Integer code) {
		this.code = code;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}
