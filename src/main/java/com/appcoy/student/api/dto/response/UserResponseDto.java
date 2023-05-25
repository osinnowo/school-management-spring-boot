package com.appcoy.student.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
}
