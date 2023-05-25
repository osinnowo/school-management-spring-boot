package com.appcoy.student.api.controller;

import com.appcoy.student.api.app.BaseResponse;
import com.appcoy.student.api.dto.response.DepartmentResponseDto;
import com.appcoy.student.api.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.appcoy.student.api.app.BaseResponse.failResponse;
import static com.appcoy.student.api.app.BaseResponse.okResponse;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Mono<ResponseEntity<BaseResponse<List<DepartmentResponseDto>>>> getAllDepartments() {
        return departmentService
                .getAllDepartments()
                .collectList()
                .map(BaseResponse::okResponse)
                .defaultIfEmpty(okResponse())
                ;
    }

    @GetMapping("{departmentId}")
    public Mono<ResponseEntity<BaseResponse<DepartmentResponseDto>>> getDepartmentsBy(@PathVariable @Validated Long id) {
        return departmentService
                .getDepartmentBy(id)
                .map(BaseResponse::okResponse)
                .defaultIfEmpty(failResponse())
                ;
    }
}
