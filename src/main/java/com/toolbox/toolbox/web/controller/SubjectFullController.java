package com.toolbox.toolbox.web.controller;

import com.toolbox.toolbox.Domain.DTO.SubjectFullDTO;
import com.toolbox.toolbox.service.SubjectFullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjectfull/")
public class SubjectFullController {
    SubjectFullService subjectFullService;

    @Autowired
    public SubjectFullController(SubjectFullService subjectFullService) {
        this.subjectFullService = subjectFullService;
    }

    @GetMapping
    public List<SubjectFullDTO> getAllSubjects() {
        return subjectFullService.getAllSubjects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubjectFullDTO> getSubjectById(@PathVariable String id) {
        SubjectFullDTO subjectDTO = subjectFullService.getSubjectById(id);
        return subjectDTO != null ? ResponseEntity.ok(subjectDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public SubjectFullDTO createSubject(@RequestBody SubjectFullDTO subjectDTO) {
        return subjectFullService.createSubject(subjectDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
        subjectFullService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

}
