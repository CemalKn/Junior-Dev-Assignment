package com.student.payload.mapper;

import com.student.entity.Grades;
import com.student.entity.Student;
import com.student.payload.request.StudentRequest;
import com.student.payload.response.GradesResponse;
import com.student.payload.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
// Mapper class for converting between request, entity, and response classes related to students
public class StudentMapper {

    private final GradesMapper gradesMapper;

    // Method to convert a request object to an entity object
    public Student studentRequestToStudent(StudentRequest studentRequest){
        return Student.builder()
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .stdNumber(studentRequest.getStdNumber())
                .build();
    }

    // Method to convert an entity object to a response object
    public StudentResponse studentToStudentResponse(Student student, List<Grades> gradesList){
        // Method to convert an entity object to a response object
        List<GradesResponse> gradesResponseList = gradesList.stream().map(gradesMapper::gradesToGradesResponse).collect(Collectors.toList());

        return StudentResponse.builder()
                .name(student.getName())
                .surname(student.getSurname())
                .stdNumber(student.getStdNumber())
                .grades(gradesResponseList)
                .build();
    }
}
