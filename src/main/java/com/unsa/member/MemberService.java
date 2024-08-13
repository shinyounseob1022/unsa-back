package com.unsa.member;

import com.unsa.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseDto signup(SignupDto signupDto) {

        String message = "";

        Member member = memberRepository.findByEmail(signupDto.getEmail()).orElse(null);

        if (member != null) {
            message = "이미 존재하는 이메일입니다.";
            return ResponseDto.fail(message);
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
        message = "회원 가입 성공.";

        return ResponseDto.success(message, member);
    }

    public ResponseDto getMember(Long id) {

        String message = "";
        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) {
            message = "존재하지 않는 회원입니다.";
            return ResponseDto.fail(message);
        }
        message = "회원 조회 성공.";

        return ResponseDto.success(message, member);
    }

}
