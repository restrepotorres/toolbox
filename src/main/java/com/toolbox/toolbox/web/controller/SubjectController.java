package com.toolbox.toolbox.web.controller;

import com.toolbox.toolbox.Domain.repository.SubjectRepository;
import com.toolbox.toolbox.persistance.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping("/add")
    public void addSubject(@RequestBody Subject subject){
        subjectRepository.save(subject);

    }

    @GetMapping("/getall")
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Subject getSubjectById(@PathVariable String id){
        Optional<Subject> user = subjectRepository.findById(id);
        return user.orElse(null);
    }
}
