package com.unsa.chat.dto;

import com.unsa.chat.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatMessageDto {

    private String sender;
    private String message;
    private ChatRoom chatRoom;

    @Builder
    public ChatMessageDto(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }

}
