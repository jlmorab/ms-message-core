package com.jlmorab.ms.message;

import com.jlmorab.ms.enums.WebSocketActionEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketMessage {

	private WebSocketActionEnum action;
	private String channel;
	private String payload;
	private long timestamp;
	
}
