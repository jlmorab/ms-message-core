package com.jlmorab.ms.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

class WebSocketActionEnumTest {
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Data
	@AllArgsConstructor
	static class TestClass {
		private WebSocketActionEnum action;
	}
	
	
	@ParameterizedTest
	@MethodSource("webSocketActionEnumProvider")
	void fromString_withCorrectString_shouldBeObtainEnumExpected( String text, WebSocketActionEnum expected ) {
		WebSocketActionEnum actual = WebSocketActionEnum.fromString( text );
		assertEquals( expected, actual );
	}//end fromString_withCorrectString_shouldBeObtainEnumExpected()
	
	@ParameterizedTest
	@MethodSource("webSocketActionEnumUnknownProvider")
	void fromString_withNullString_shouldBeThrowException( String text ) {
		Exception actual = assertThrows( IllegalArgumentException.class, () -> {
			WebSocketActionEnum.fromString( text );
		});
		assertEquals( "Unknown action: " + text, actual.getMessage() );
	}//end fromString_withNullString_shouldBeThrowException()
	
	static Stream<Arguments> webSocketActionEnumUnknownProvider() {
		return Stream.of(
			Arguments.of((String) null),
			Arguments.of(""),
			Arguments.of("unknown") );
	}//end webSocketActionEnumUnknownProvider()
	
	@ParameterizedTest
	@MethodSource("webSocketActionEnumProvider")
	void toValue_shouldBeReturnNameLowerCase( String expected, WebSocketActionEnum element ) throws Exception {
		TestClass testClass = new TestClass( element );
		
		String actual = mapper.writeValueAsString( testClass );
		
		assertThat( actual )
			.contains( "\"action\":\"" + expected + "\"" );
	}//end toValue_shouldBeReturnNameLowerCase()
	
	
	static Stream<Arguments> webSocketActionEnumProvider() {
		return Stream.of( WebSocketActionEnum.values() )
			.flatMap( t -> Stream.of( Arguments.of( t.name().toLowerCase(), t ) ));
	}//end webSocketActionEnumProvider()

}
