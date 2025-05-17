package com.jlmorab.ms.message;

import java.util.function.Consumer;

public interface MessageConsumer<T> {

	public void suscribe( String channel, Consumer<T> messageHandler );
	public void unsuscribe( String channel );
	
}
