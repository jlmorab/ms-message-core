package com.jlmorab.ms.message;

public interface MessageFactory {

	<T> MessageProducer<T> createProducer( Class<T> messageType );
	<T> MessageConsumer<T> createConsumer( Class<T> messageType );
	
}
