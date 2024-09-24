package com.Collage.Management.CollageManagementSyatem.entiites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToOne(mappedBy = "admittedStudent")
    @JsonIgnore
    private AdmissionEntity admittedStud;


    @ManyToMany
    @JoinTable(name = "student_professor_mapping",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "professor_id"))
    @JsonIgnore
    private Set<ProfessorEntity> studentProfessor;

    @ManyToMany(mappedBy = "studentSubjects")
    private Set<SubjectEntity> subjectsOfStudents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
