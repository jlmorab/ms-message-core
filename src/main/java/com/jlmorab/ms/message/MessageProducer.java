package com.jlmorab.ms.message;

import java.util.Map;

public interface MessageProducer<T> {
	
	public void sendMessage( String channel, T message );
	public void sendMessage( String channel, T message, Map<String, Object> headers );
	
}
