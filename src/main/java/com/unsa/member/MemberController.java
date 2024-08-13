package com.unsa.member;

import com.unsa.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return memberService.signup(signupDto);
    }

    @GetMapping("/{id}")
    public ResponseDto getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }
}
