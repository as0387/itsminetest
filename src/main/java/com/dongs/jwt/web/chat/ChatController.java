package com.dongs.jwt.web.chat;

import lombok.RequiredArgsConstructor;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.dongs.jwt.dto.ChatMessageDTO;

@Controller
@RequiredArgsConstructor
public class ChatController {
	private final SimpMessagingTemplate template;//특정 Broker로 메세지를 전달
	
	//클라이언트가 send할수 있는 경로
	//stompconfig에서 설정한 applicaterionDestinationPreFixes와 @MessageMapping 경로가 병합됨
	@MessageMapping("/chat/enter")
	public void enter(ChatMessageDTO message) {
		message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
		template.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
	}
	
	@MessageMapping("/chat/message")
	public void message(ChatMessageDTO message) {
		template.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
	}
	
}
