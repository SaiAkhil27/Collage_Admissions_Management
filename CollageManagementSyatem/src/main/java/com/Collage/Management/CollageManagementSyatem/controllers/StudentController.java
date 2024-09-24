package com.Collage.Management.CollageManagementSyatem.controllers;

import com.Collage.Management.CollageManagementSyatem.entiites.StudentEntity;
import com.Collage.Management.CollageManagementSyatem.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    private StudentEntity getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @PostMapping
    private StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @PutMapping("/{studentId}/assignSubjectsToStudent/{subjectId}")
    private StudentEntity getSubjectsOfStudents(@PathVariable Long studentId,
                                                @PathVariable Long subjectId){
        return studentService.getSubjectsOfStudents(studentId,subjectId);
    }
}
