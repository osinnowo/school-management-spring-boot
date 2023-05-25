package com.appcoy.student.api.service;

import com.appcoy.student.api.dto.request.UserDto;
import com.appcoy.student.api.dto.response.UserResponseDto;
import com.appcoy.student.api.mapper.UserMapper;
import com.appcoy.student.api.model.User;
import com.appcoy.student.api.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    protected AuthRepository authRepository;

    public Flux<UserResponseDto> getUserList() {
        return Flux.fromIterable(
                authRepository
                        .findAll()
                        .stream()
                        .map(UserMapper::mapUserFrom)
                        .collect(Collectors.toList())
        );
    }

    public Mono<UserResponseDto> createUser(UserDto requestDto) {
        User user = authRepository.save(UserMapper.mapToUser(requestDto));
        return Mono.just(UserMapper.mapUserFrom(user));
    }
}
