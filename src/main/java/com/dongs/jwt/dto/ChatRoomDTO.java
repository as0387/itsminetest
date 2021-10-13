package com.dongs.jwt.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomDTO {
	private String roomId;
	private String name;
	private Set<WebSocketSession> session = new HashSet<>(); //WebSocketSession은 Spring에서 Websocket Connection이 맻어진 세션
	
	public static ChatRoomDTO create(String name) {
		ChatRoomDTO room = new ChatRoomDTO();
		
		room.roomId = UUID.randomUUID().toString();
		room.name = name;
		return room;
	}
}
