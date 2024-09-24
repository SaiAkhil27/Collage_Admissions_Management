package com.Collage.Management.CollageManagementSyatem.services;

import com.Collage.Management.CollageManagementSyatem.entiites.AdmissionEntity;
import com.Collage.Management.CollageManagementSyatem.entiites.StudentEntity;
import com.Collage.Management.CollageManagementSyatem.repositories.AdmissionRepository;
import com.Collage.Management.CollageManagementSyatem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissinService {

    private final AdmissionRepository admissionRepository;
    private final StudentRepository studentRepository;

    public AdmissinService(AdmissionRepository admissionRepository, StudentRepository studentRepository) {
        this.admissionRepository = admissionRepository;
        this.studentRepository = studentRepository;
    }

    public List<AdmissionEntity> getAllAdmissions() {
        return admissionRepository.findAll();
    }
    public AdmissionEntity getAdmissionBydId(Long admissionId) {
return admissionRepository.findById(admissionId).orElse(null);

    }

    public AdmissionEntity createAdmission(AdmissionEntity admissionEntity) {
        return admissionRepository.save(admissionEntity);
    }

    public AdmissionEntity mapAdmissionToStudent(Long admissionId, Long studentId) {

        Optional<AdmissionEntity> admissionEntity = admissionRepository.findById(admissionId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

   return admissionEntity.flatMap(admission ->
              studentEntity.map(student->{
                 admission.setAdmittedStudent(student);

                 return admissionRepository.save(admission);
              })).orElse(null);

    }
}
