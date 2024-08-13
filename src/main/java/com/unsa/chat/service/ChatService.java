package com.unsa.chat.service;

import com.unsa.chat.entity.ChatMessage;
import com.unsa.chat.repository.ChatMessageRepository;
import com.unsa.chat.repository.ChatRoomMemberRepository;
import com.unsa.chat.repository.ChatRoomRepository;
import com.unsa.chat.dto.ChatRoomDto;
import com.unsa.chat.entity.ChatRoom;
import com.unsa.common.ResponseDto;
import com.unsa.member.Member;
import com.unsa.chat.entity.ChatRoomMember;
import com.unsa.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomMemberRepository chatRoomMemberRepository;
    private final MemberRepository memberRepository;

    public ResponseDto createChatRoom(ChatRoomDto chatRoomDto) {

        String message = "";
        String email = chatRoomDto.getEmail();
        String roomName = chatRoomDto.getRoomName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다"));

        ChatRoom chatRoom = ChatRoom.builder()
                .roomName(roomName)
                .build();
        chatRoomRepository.save(chatRoom);

        ChatRoomMember chatRoomMember = ChatRoomMember.builder()
                .chatRoom(chatRoom)
                .member(member)
                .build();
        chatRoomMemberRepository.save(chatRoomMember);

        message = "채팅방 생성 성공.";

        return ResponseDto.success(message, chatRoom);
    }

    public ChatMessage saveChatMessage(Long roomId, String sender, String message) {

        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채팅방 아이디입니다."));

        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .sender(sender)
                .message(message)
                .build();
        chatMessageRepository.save(chatMessage);

        return chatMessage;
    }

    public ResponseDto getRoomList() {
        List<ChatRoom> chatRoomList = chatRoomRepository.findAll();
        String message = "채팅방 전체 조회 성공.";
        return ResponseDto.success(message, chatRoomList);
    }
}
