package com.unsa.chat.entity;

import com.unsa.common.TimeStamp;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CHAT_ROOM")
@Getter
@NoArgsConstructor
public class ChatRoom extends TimeStamp {

    @Id @GeneratedValue
    @Column(name = "ROOM_ID")
    private Long id;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.REMOVE) // CascadeType.REMOVE : 부모 엔티티가 삭제되면 자식 엔티티도 삭제
    private List<ChatMessage> chatMessageList;

    @Builder
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

}
