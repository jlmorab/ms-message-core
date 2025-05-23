package com.jlmorab.ms.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jlmorab.ms.enums.WebSocketActionEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebSocketMessage {

	private WebSocketActionEnum action;
	private String channel;
	private String payload;
	private long timestamp;
	
}
