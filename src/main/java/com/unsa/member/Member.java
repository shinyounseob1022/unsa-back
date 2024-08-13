package com.unsa.member;

import com.unsa.common.TimeStamp;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
@Getter
@NoArgsConstructor
public class Member extends TimeStamp {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_ROLE")
    private RoleType role;

    @Builder
    public Member(String email, String name, LocalDate birthday,
                  String address, String password, RoleType role) {
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.password = password;
        this.role = role;
    }

}
