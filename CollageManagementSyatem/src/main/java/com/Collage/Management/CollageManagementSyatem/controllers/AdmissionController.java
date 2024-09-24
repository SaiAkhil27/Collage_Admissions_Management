package com.Collage.Management.CollageManagementSyatem.controllers;

import com.Collage.Management.CollageManagementSyatem.entiites.AdmissionEntity;
import com.Collage.Management.CollageManagementSyatem.entiites.StudentEntity;
import com.Collage.Management.CollageManagementSyatem.services.AdmissinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Admission")
public class AdmissionController {

    private final AdmissinService admissinService;


    public AdmissionController(AdmissinService admissinService) {
        this.admissinService = admissinService;
    }

    @GetMapping("/{admissionId}")
    private AdmissionEntity getAdmissionBydId(@PathVariable Long admissionId){
        return admissinService.getAdmissionBydId(admissionId);
    }
    @GetMapping
    public ResponseEntity<List<AdmissionEntity>> getAllAdmissions() {
        List<AdmissionEntity> admissions = admissinService.getAllAdmissions();
        return ResponseEntity.ok(admissions);
    }

    @PostMapping
    private  AdmissionEntity createAdmission(@RequestBody AdmissionEntity admissionEntity){
        return admissinService.createAdmission(admissionEntity);
    }
    @PutMapping("/{admissionId}/admitted/{studentId}")
    private AdmissionEntity mapAdmissionToStudent(@PathVariable Long admissionId, @PathVariable Long studentId){
        return admissinService.mapAdmissionToStudent(admissionId,studentId);
    }
}
