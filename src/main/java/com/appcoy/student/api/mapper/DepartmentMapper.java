package com.appcoy.student.api.mapper;

import com.appcoy.student.api.dto.response.DepartmentResponseDto;
import com.appcoy.student.api.model.Department;

import java.util.stream.Collectors;

public class DepartmentMapper {
    public static DepartmentResponseDto mapFromDepartment(Department entity) {
        DepartmentResponseDto department = DepartmentResponseDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateCreated(entity.getDateCreated())
                .users(entity
                        .getUsers()
                        .stream()
                        .map(UserMapper::mapUserFrom)
                        .collect(Collectors.toList())
                )
                .build();
        return department;
    }
}
