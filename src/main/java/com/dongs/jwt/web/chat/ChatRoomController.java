package com.dongs.jwt.web.chat;


import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongs.jwt.domain.chat.ChatRoom;
import com.dongs.jwt.repository.ChatRoomRepository;

import jdk.internal.org.jline.utils.Log;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    //채팅방 목록 조회
    @GetMapping("/rooms")
    @ResponseBody
    public ModelAndView room() {
    	ModelAndView mv = new ModelAndView("/chat/rooms");
    	
    	mv.addObject("list", chatRoomRepository.findAllRoom());
        return mv;
    }
    
    //채팅방 개설
    
    @PostMapping("/room")
    public String create(@RequestParam String name, RedirectAttributes rttr) {
    	rttr.addFlashAttribute("roomName", chatRoomRepository.createChatRoom(name));
    	return "redirect:/chat/rooms";
    }
    
    //채팅방 조회
    @GetMapping("/room")
    public void getRoom(String roomId, Model model) {
    	model.addAttribute("room", chatRoomRepository.findRoomById(roomId));
    }
}