package com.student.payload.request;

import com.student.entity.Grades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// Request class representing student information
public class StudentRequest {

    //@NotBlank I did not use annotation because I validated the data entered by the user myself.
    private String name;

    private String surname;

    private String stdNumber;

    private List<GradesRequest> grades;
}
