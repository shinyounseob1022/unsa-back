package com.unsa.chat.controller;

import com.unsa.chat.dto.ChatRoomDto;
import com.unsa.chat.entity.ChatRoom;
import com.unsa.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatRestController {

    private final ChatService chatService;

    @PostMapping("/room")
    public ResponseEntity<String> createChatRoom(@RequestBody ChatRoomDto chatRoomDto) {
        return ResponseEntity.ok(chatService.createChatRoom(chatRoomDto));
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<ChatRoom>> getRoomList() {
        return ResponseEntity.ok(chatService.getRoomList());
    }

}
