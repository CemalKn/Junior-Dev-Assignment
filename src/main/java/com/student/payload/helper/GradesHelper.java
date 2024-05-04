package com.student.payload.helper;

import com.student.entity.Grades;
import com.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
// Helper class for calculating average grades
public class GradesHelper {

    public List<Grades> averageGrades(List<Grades> gradesList, Student student){
        Map<String, List<Integer>> nameAndValueMap = new HashMap<>();

        // Combine grade values for the same courses
        gradesList.forEach(grade -> {
            nameAndValueMap.computeIfAbsent(grade.getCode(), k -> new ArrayList<>()).add(grade.getValue());
        });

        List<Grades> result = new ArrayList<>();

        // Calculate the average grade for each course
        nameAndValueMap.forEach((name,values) -> {
            int sum = values.stream().mapToInt(Integer::intValue).sum();
            Integer average = sum / values.size();
            result.add(Grades.builder().code(name).value(average).student(student).build());
        });

        return result;
    }
}
