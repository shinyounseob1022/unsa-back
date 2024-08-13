package com.unsa.chat.controller;

import com.unsa.chat.dto.ChatRoomDto;
import com.unsa.chat.service.ChatService;
import com.unsa.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatRestController {

    private final ChatService chatService;

    @PostMapping("/room")
    public ResponseDto createChatRoom(@RequestBody ChatRoomDto chatRoomDto) {
        return chatService.createChatRoom(chatRoomDto);
    }

    @GetMapping("/rooms")
    public ResponseDto getRoomList() {
        return chatService.getRoomList();
    }

}
