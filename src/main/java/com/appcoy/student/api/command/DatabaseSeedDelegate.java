package com.appcoy.student.api.command;

import com.appcoy.student.api.model.Department;
import com.appcoy.student.api.model.User;
import com.appcoy.student.api.repository.AuthRepository;
import com.appcoy.student.api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeedDelegate implements CommandLineRunner {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        seedDepartments();
    }

    private void seedDepartments() {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Williams", "Brooke", "male", "williams.brooke@gmail.com", LocalDate.of(1993, 10, 10), "2348060203430", null),
                new User("Catherine", "Judge", "female", "catherine.judge@gmail.com", LocalDate.of(1982, 6, 23), "2348060403431", null),
                new User("Ferdinand", "Godwills", "male", "ferdinand.godwills@gmail.com", LocalDate.of(1963, 12, 18), "2348060203430", null)
        ));

        Department department = new Department("Chemical & Organic Engineering", users);
        departmentRepository.saveAndFlush(department);

        List<Department> departments = new ArrayList<>(Arrays.asList(
                new Department("Mechanical Engineering", null),
                new Department("Industrial Engineering", null),
                new Department("Information Technology", null),
                new Department("Research & Development", null),
                new Department("Medical & Health", null),
                new Department("Wood & Plant Engineering", null)
        ));
        departmentRepository.saveAllAndFlush(departments);
    }
}
