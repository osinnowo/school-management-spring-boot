package com.appcoy.student.api.controller;

import com.appcoy.student.api.app.BaseResponse;
import com.appcoy.student.api.dto.request.UserDto;
import com.appcoy.student.api.dto.response.UserResponseDto;
import com.appcoy.student.api.model.User;
import com.appcoy.student.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.appcoy.student.api.app.BaseResponse.*;

@RequestMapping(
        value = "/auth",
        produces = "application/json",
        consumes = "application/json"
)
@RestController
public class AuthController {

    @Autowired
    protected AuthService authService;
    @PostMapping
    public Mono<ResponseEntity<BaseResponse<?>>> doLogin() {
        return Mono.empty();
    }

    @GetMapping("/users")
    public Mono<ResponseEntity<BaseResponse<List<UserResponseDto>>>> getAllUsers() {
        return authService.getUserList()
                .collectList()
                .map(BaseResponse::okResponse)
                .defaultIfEmpty( failResponse() );
    }

    @GetMapping("/users/{userId}")
    public Mono<ResponseEntity<BaseResponse<User>>> getUserBy(@PathVariable @Validated String userId) throws Exception {
        throw new Exception("Something went wrong");
    }

    @PostMapping("/user")
    public Mono<ResponseEntity<BaseResponse<UserResponseDto>>> createUser(@RequestBody @Validated UserDto user) {
        return authService.createUser(user)
                .flatMap(item -> Mono.just(ResponseEntity.ok(BaseResponse.ok(item))));
    }
}
