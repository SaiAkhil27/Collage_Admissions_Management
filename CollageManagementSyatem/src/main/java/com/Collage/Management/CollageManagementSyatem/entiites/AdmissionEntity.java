package com.Collage.Management.CollageManagementSyatem.entiites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Admissions")
public class AdmissionEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private Integer fees;

@OneToOne
@JoinColumn(name = "Admission_Student")
private StudentEntity admittedStudent;

}
