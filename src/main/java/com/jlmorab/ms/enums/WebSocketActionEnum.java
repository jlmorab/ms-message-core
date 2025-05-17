package com.jlmorab.ms.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WebSocketActionEnum {
	
	SUBSCRIBE,
	UNSUBSCRIBE,
	SEND,
	MESSAGE,
	SUBSCRIBED,
	UNSUBSCRIBED,
	ERROR;
	
	@JsonCreator
	public static WebSocketActionEnum fromString( String text ) {
		try {
			return WebSocketActionEnum.valueOf( text.toUpperCase() );
		} catch( Exception e ) {
			throw new IllegalArgumentException("Unknown action: " + text);
		}//end try
	}//end fromString()
	
	@JsonValue
	public String toValue() {
		return name().toLowerCase();
	}//end toValue()
	
}
