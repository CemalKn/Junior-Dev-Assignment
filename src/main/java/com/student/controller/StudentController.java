package com.student.controller;

import com.student.payload.request.StudentRequest;
import com.student.payload.response.StudentResponse;
import com.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping({"/create","/create/"})
    // Method for creating a new student
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest){
        // Calls the addStudent method of StudentService to add a new student
        return studentService.addStudent(studentRequest);
    }
}



