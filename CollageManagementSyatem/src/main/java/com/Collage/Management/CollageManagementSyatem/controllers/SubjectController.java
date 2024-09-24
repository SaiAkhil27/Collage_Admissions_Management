package com.Collage.Management.CollageManagementSyatem.controllers;


import com.Collage.Management.CollageManagementSyatem.entiites.SubjectEntity;
import com.Collage.Management.CollageManagementSyatem.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {
   private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping("/{subjectId}")
    private SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }
    @PostMapping()
    private SubjectEntity createSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createSubject(subjectEntity);
    }

}
