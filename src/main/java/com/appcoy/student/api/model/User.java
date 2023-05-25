package com.appcoy.student.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder
public class User extends BaseEntity<User> {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
