package com.student.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String stdNumber;

    // This represents a one-to-many relationship: a student may have many grades.
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Grades> grades;
}
