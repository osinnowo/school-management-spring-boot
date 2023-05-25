package com.appcoy.student.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Data
public class UserDto {

    @NonNull
    @Size(min = 4, max = 28, message = "Invalid first name length, please try again!")
    public String firstName;

    @NonNull
    @Size(min = 4, max = 28, message = "Invalid last name length, please try again!")
    public String lastName;

    @NonNull
    @Pattern(regexp = "^(male|female)$", message = "Gender must be a male or female")
    public String gender;

    @NonNull
    @Email(message = "Please enter valid email address")
    public String email;

    @NonNull
    @Pattern(regexp = "^234\\d{10}$", message = "Invalid phone number, please try again!")
    public String phoneNumber;

    @NonNull
    @Past(message = "Date must be in the past")
    public LocalDate dateOfBirth;
}
