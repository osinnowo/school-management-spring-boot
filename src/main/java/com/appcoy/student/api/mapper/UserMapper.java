package com.appcoy.student.api.mapper;

import com.appcoy.student.api.dto.request.UserDto;
import com.appcoy.student.api.dto.response.UserResponseDto;
import com.appcoy.student.api.model.User;

final public class UserMapper {
    public static User mapToUser(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .gender(userDto.getGender())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .dateOfBirth(userDto.getDateOfBirth())
                .build();
    }

    public static UserResponseDto mapUserFrom(User entity) {
        return UserResponseDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .dateOfBirth(entity.getDateOfBirth())
                .build();
    }
}
