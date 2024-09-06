package com.unsa.member;

import com.unsa.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseDto<Member> signup(@RequestBody SignupDto signupDto) {
        return memberService.signup(signupDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<Member> getMember(@PathVariable("id") Long id) {
        return memberService.getMember(id);
    }

}
