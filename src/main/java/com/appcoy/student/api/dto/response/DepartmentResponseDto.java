package com.appcoy.student.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DepartmentResponseDto {
    private Long id;
    private String name;
    private LocalDate dateCreated;
    private List<UserResponseDto> users;
}
