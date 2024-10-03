package com.toolbox.toolbox.web.controller;

import com.toolbox.toolbox.Domain.DTO.SubjectBasicDTO;
import com.toolbox.toolbox.Domain.DTO.SubjectFullDTO;
import com.toolbox.toolbox.service.SubjectBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/subjectbasic/")
public class SubjectBasicController {
    SubjectBasicService subjectBasicService;

    @Autowired
    public SubjectBasicController(SubjectBasicService subjectBasicService) {
        this.subjectBasicService = subjectBasicService;
    }

    @GetMapping
    public List<SubjectBasicDTO> getAllSubjects() {
        return subjectBasicService.getAllSubjects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubjectFullDTO> getSubjectById(@PathVariable String id) {
        SubjectBasicDTO subjectDTO = subjectBasicService.getSubjectById(id);
        return subjectDTO != null ? (ResponseEntity<SubjectFullDTO>) ResponseEntity.ok() : ResponseEntity.notFound().build();
    }

}
