package com.toolbox.toolbox.web.controller;

import com.toolbox.toolbox.Domain.repository.SubjectRepository;
import com.toolbox.toolbox.persistance.entity.Subject;
import com.toolbox.toolbox.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public void addSubject(@RequestBody Subject subject){
        subjectService.save(subject);

    }

    @GetMapping("/getall")
    public List<Subject> getAllSubject(){
        return subjectService.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable String id){
        Optional<Subject> subject = subjectService.findById(id);
        return subject.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubject(@PathVariable String id){
        Optional<Subject> subject = subjectService.findById(id);
        subject.ifPresent(value -> subjectService.delete(value));
    }

    @PutMapping
    public void updateSubject(@RequestBody Subject subject){
       subjectService.save(subject);
    }
}
