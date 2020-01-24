package com.wearechurch.tool.exception;

import com.wearechurch.tool.enumerator.Reply;

public class RarityException extends RuntimeException {

	private static final long serialVersionUID = 6954520900598417292L;
	private final Reply reply;

	public RarityException(final Reply reply) {
		this.reply = reply;
	}

	public Reply getReply() {
		return reply;
	}

}
