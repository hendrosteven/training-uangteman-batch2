package com.uangteman.dto;

public class Messages {
	
	public enum MessageType {
		ERROR, INFO
	}
	
	private MessageType type;
	private String message;
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
