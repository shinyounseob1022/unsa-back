package com.unsa.auth.controller;

import com.unsa.auth.dto.LoginDto;
import com.unsa.auth.dto.TokenDto;
import com.unsa.auth.jwt.JwtFilter;
import com.unsa.auth.service.LoginService;
import com.unsa.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseDto<TokenDto> login(@RequestBody LoginDto loginDto) {

        String jwt = loginService.login(loginDto);

        //HttpHeaders httpHeaders = new HttpHeaders();
        // response header에 jwt token에 넣어줌
        //httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, jwt);

        // tokenDto를 이용해 response body에도 넣어서 리턴
        //return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
        return ResponseDto.success(new TokenDto(jwt));
    }

}
