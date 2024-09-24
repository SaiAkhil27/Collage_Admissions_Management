package com.Collage.Management.CollageManagementSyatem.services;


import com.Collage.Management.CollageManagementSyatem.entiites.ProfessorEntity;
import com.Collage.Management.CollageManagementSyatem.entiites.StudentEntity;
import com.Collage.Management.CollageManagementSyatem.entiites.SubjectEntity;
import com.Collage.Management.CollageManagementSyatem.repositories.ProfessorRepository;
import com.Collage.Management.CollageManagementSyatem.repositories.StudentRepository;
import com.Collage.Management.CollageManagementSyatem.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    private final StudentRepository studentRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public ProfessorEntity getProfessorById(Long professorId) {

        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignProfessorToSubjects(Long professorId, Long subjectsId) {

        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectsId);

        return professorEntity.flatMap(professor ->
            subjectEntity.map(subject->{
       subject.setSubjectsTaught(professor);
       subjectRepository.save(subject);
  professor.getTeachedSubs().add(subject);

  return professor;
            })).orElse(null);

    }

    public List<ProfessorEntity> getAllProfessors() {
        return professorRepository.findAll();
    }

    public ProfessorEntity assignStudentsToProfessor(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return professorEntity.flatMap(professor->
                studentEntity.map(student ->{
                student.getStudentProfessor().add(professor);
                studentRepository.save(student);
                professor.getStudents().add(student);

     return professor;
                } )).orElse(null);

    }
}
