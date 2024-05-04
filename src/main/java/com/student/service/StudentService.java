package com.student.service;

import com.student.entity.Grades;
import com.student.entity.Student;
import com.student.payload.helper.GradesHelper;
import com.student.payload.mapper.GradesMapper;
import com.student.payload.mapper.StudentMapper;
import com.student.payload.messages.ErrorMessages;
import com.student.payload.request.StudentRequest;
import com.student.payload.response.StudentResponse;
import com.student.payload.validator.NullEmptyAndNumberValidator;
import com.student.repository.StudentRepository;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final GradesService gradesService;

    // Method to add a new student
    public ResponseEntity<StudentResponse> addStudent(StudentRequest studentRequest) {

        //Checking if there is a student with the student number received from the request
        if (studentRepository.existsByStdNumber(studentRequest.getStdNumber())) {
            throw new DuplicateRequestException(ErrorMessages.STD_NUMBER_ALREADY_EXISTS);
        }

        // Validate the student request
        NullEmptyAndNumberValidator.validateStudentRequest(studentRequest);

        // Validate the grades request for the student
        studentRequest.getGrades().forEach(NullEmptyAndNumberValidator::validateGradesRequest);

        // Map the student request to a student entity
        Student student = studentMapper.studentRequestToStudent(studentRequest);

        // Save the student entity
        student = studentRepository.save(student);

        // Saving all grade entities
        List<Grades> gradesList = gradesService.saveALlGrades(studentRequest.getGrades(),student);

        // Map the student entity to a student response
        StudentResponse studentResponse = studentMapper.studentToStudentResponse(student,gradesList);

        // Return the student response with HTTP status CREATED
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);

    }
}
