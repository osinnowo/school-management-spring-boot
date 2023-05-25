package com.appcoy.student.api.service;

import com.appcoy.student.api.dto.response.DepartmentResponseDto;
import com.appcoy.student.api.exception.DepartmentNotFoundException;
import com.appcoy.student.api.mapper.DepartmentMapper;
import com.appcoy.student.api.repository.DepartmentRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private Logger logger = LoggerFactory.getLogger(DepartmentService.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    public Flux<DepartmentResponseDto> getAllDepartments() {
        return Flux.fromIterable(
            departmentRepository
                    .findAll()
                    .stream()
                    .map(DepartmentMapper::mapFromDepartment)
                    .collect(Collectors.toList())
        );
    }

    public Mono<DepartmentResponseDto> getDepartmentBy(Long id) {
        return getAllDepartments()
                .filter(item -> item.getId().equals(id))
                .next()
                .switchIfEmpty(Mono.error(new DepartmentNotFoundException(String.format("Department with id %d cannot be found", id))));
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("postConstruct for DepartmentService");
    }
}
