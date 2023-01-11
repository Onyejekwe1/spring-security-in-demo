package io.ifeanyi.springsecurityinaction.controller;

import io.ifeanyi.springsecurityinaction.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Student> students(){

        Student student = new Student();
        student.setId(1);
        student.setFirstName("James");
        student.setLastName("Harden");

        Student student1 = new Student();
        student1.setId(2);
        student1.setFirstName("Lamb");
        student1.setLastName("Trust");

        students.add(student1);
        students.add(student);

        return students;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
   public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
