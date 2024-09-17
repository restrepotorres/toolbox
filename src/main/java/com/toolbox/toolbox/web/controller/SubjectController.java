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

    @Autowired
    SubjectService subjectService;

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
        if (subject.isPresent()) {
            return ResponseEntity.ok(subject.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
