package com.student.payload.mapper;

import com.student.entity.Grades;
import com.student.payload.request.GradesRequest;
import com.student.payload.response.GradesResponse;
import org.springframework.stereotype.Component;

@Component
public class GradesMapper {

    // Method to convert a request object to an entity object
    public Grades gradesRequestToGrades(GradesRequest gradesRequest){
        return Grades.builder()
                .code(gradesRequest.getCode())
                .value(gradesRequest.getValue())
                .build();
    }

    // Method to convert an entity object to a response object
    public GradesResponse gradesToGradesResponse(Grades grades){
        return GradesResponse.builder()
                .code(grades.getCode())
                .value(grades.getValue())
                .build();
    }
}
