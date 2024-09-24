package com.Collage.Management.CollageManagementSyatem.controllers;


import com.Collage.Management.CollageManagementSyatem.entiites.ProfessorEntity;
import com.Collage.Management.CollageManagementSyatem.services.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {
    private final ProfessorService professorService;


    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }
    @GetMapping("/{professorId}")
    private ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }


    @PostMapping
    private ProfessorEntity createProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createProfessor(professorEntity);
    }
    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> getAllProfessors() {
        List<ProfessorEntity> professors = professorService.getAllProfessors();
        return ResponseEntity.ok(professors);
    }

    @PutMapping("/{professorId}/subjectsTaugth/{subjectsId}")
    private ProfessorEntity assignProfessorToSubjects(@PathVariable Long professorId,
                                                      @PathVariable Long subjectsId){
        return professorService.assignProfessorToSubjects(professorId,subjectsId);
    }

    @PutMapping("/{professorId}/studentsToProfessor/{studentId}")
    private ProfessorEntity assignStudentsToProfessor(@PathVariable Long professorId,
                                                      @PathVariable Long studentId){
        return professorService.assignStudentsToProfessor(professorId,studentId);
    }



}
