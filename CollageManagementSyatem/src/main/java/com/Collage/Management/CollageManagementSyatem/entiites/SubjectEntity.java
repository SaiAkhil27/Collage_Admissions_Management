package com.Collage.Management.CollageManagementSyatem.entiites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "professor_subjects")
    @JsonIgnore
    private ProfessorEntity subjectsTaught;

@ManyToMany
    @JoinTable(name = "student_subject_mapping",
    joinColumns = @JoinColumn(name = "subject_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
@JsonIgnore
    private Set<StudentEntity> studentSubjects;



}
