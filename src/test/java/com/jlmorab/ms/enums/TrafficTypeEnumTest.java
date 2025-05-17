package com.jlmorab.ms.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import com.jlmorab.ms.utils.LoggerHelper;

class TrafficTypeEnumTest {

	LoggerHelper loggerHelper = LoggerHelper.getInstance();
	
	@BeforeEach
	void setUpEach() {
		loggerHelper.initCapture();
	}//end setUpEach()
	
	@AfterEach
	void tearDownEach() {
		loggerHelper.release();
	}//end tearDownEach()
	
	
	@ParameterizedTest
	@MethodSource("trafficTypeEnumProvider")
	void fromString_withCorrectString_shouldBeObtainEnumExpected( String text, TrafficTypeEnum expected ) {
		TrafficTypeEnum actual = TrafficTypeEnum.fromString( text );
		assertEquals( expected, actual );
	}//end fromString_withCorrectString_shouldBeObtainEnumExpected()
	
	static Stream<Arguments> trafficTypeEnumProvider() {
		return Stream.of( TrafficTypeEnum.values() )
			.flatMap( t -> Stream.of(
				Arguments.of( t.name().toLowerCase(), t ),
				Arguments.of( t.getProvider().toLowerCase(), t )
			));
	}//end trafficTypeEnumProvider()
	
	@ParameterizedTest
	@NullSource
	void fromString_withNullString_shouldBeObtainDefault( String text ) {
		TrafficTypeEnum actual = TrafficTypeEnum.fromString( text );
		
		assertEquals( TrafficTypeEnum.DEFAULT, actual );
		assertThat( loggerHelper.getOutContent() )
			.contains("Received null TafficType, defaulting to DEFAULT");
	}//end fromString_withNullString_shouldBeObtainDefault()
	
	@Test
	void fromString_withUnknownString_shouldBeObtainDefault() {
		String text = "unknown";
		
		TrafficTypeEnum actual = TrafficTypeEnum.fromString( text );
		
		assertEquals( TrafficTypeEnum.DEFAULT, actual );
		assertThat( loggerHelper.getOutContent() )
			.contains("Unknown traffic type value 'unknown', defaulting to DEAFULT");
	}//end fromString_withUnknownString_shouldBeObtainDefault()

}
