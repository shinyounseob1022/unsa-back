package com.unsa.member;

import com.unsa.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseDto<Member> signup(SignupDto signupDto) {

        Member member = memberRepository.findByEmail(signupDto.getEmail()).orElse(null);

        if (member != null) {
            return ResponseDto.error("duplicate e-mail");
        }

        member = Member.builder()
                .email(signupDto.getEmail())
                .name((signupDto.getName()))
                .birthday(signupDto.getBirthday())
                .address(signupDto.getAddress())
                .password(passwordEncoder.encode(signupDto.getPassword()))
                .role(RoleType.USER)
                .build();
        memberRepository.save(member);

        return ResponseDto.success(member);
    }

    public ResponseDto<Member> getMember(Long id) {

        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) {
            return ResponseDto.error("ID that does not exist");
        }

        return ResponseDto.success(member);
    }

}
