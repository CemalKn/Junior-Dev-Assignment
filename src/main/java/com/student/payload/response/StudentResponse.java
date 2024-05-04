package com.student.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
// Response class representing student information sent to clients
public class StudentResponse {

    private String name;

    private String surname;
    private String stdNumber;

    private List<GradesResponse> grades;

}
