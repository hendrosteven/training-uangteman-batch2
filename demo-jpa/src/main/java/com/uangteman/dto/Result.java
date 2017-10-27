package com.uangteman.dto;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
	private List<String> messages = new ArrayList<String>();
	private T payload;
	
	public Result(){}

	public Result(List<String> messages, T payload) {
		super();
		this.messages = messages;
		this.payload = payload;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
	
}
