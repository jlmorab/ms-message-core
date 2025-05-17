package com.jlmorab.ms.enums;

import java.util.Optional;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public enum TrafficTypeEnum {
	
	LOCAL 	("Memory"),
	LOW 	("JMS"),
	MEDIUM 	("RabbitMQ"),
	HIGH 	("Kafka"),
	DEFAULT ("Default");
	
	@Getter
	final String provider;
	
	@JsonCreator
	public static TrafficTypeEnum fromString( String text ) {
		if( text == null ) {
			log.debug("Received null TafficType, defaulting to DEFAULT");
			return TrafficTypeEnum.DEFAULT;
		}//end if
		
		Optional<TrafficTypeEnum> match = Stream.of( TrafficTypeEnum.values() )
				.filter( t -> t.name().equalsIgnoreCase(text) || t.getProvider().equalsIgnoreCase(text) )
				.findFirst();
		
		if( match.isPresent() ) {
			log.debug("Matched traffic type '{}'", match.get().name());
			return match.get();
		} else {
			log.warn("Unknown traffic type value '{}', defaulting to DEAFULT", text);
			return TrafficTypeEnum.DEFAULT;
		}//end if
	}//end fromString()
	
}
