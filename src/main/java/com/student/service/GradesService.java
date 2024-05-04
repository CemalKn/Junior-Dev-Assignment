package com.student.service;

import com.student.entity.Grades;
import com.student.entity.Student;
import com.student.payload.helper.GradesHelper;
import com.student.payload.mapper.GradesMapper;
import com.student.payload.request.GradesRequest;
import com.student.repository.GradesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GradesService {

    private final GradesRepository gradesRepository;
    private final GradesMapper gradesMapper;
    private final GradesHelper gradesHelper;

    // Method to save a list of grades
    public List<Grades> saveALlGrades(List<GradesRequest> gradesRequestsList, Student student){
        // Map the grades request to a grades entity
        List<Grades> gradesList = gradesRequestsList.stream().map(gradesMapper::gradesRequestToGrades).collect(Collectors.toList());

        // Calculate average grades for the student
        gradesList = gradesHelper.averageGrades(gradesList,student);

        // Method to save a list of grades
        return gradesRepository.saveAll(gradesList);
    }

}
