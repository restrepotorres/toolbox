package com.toolbox.toolbox.web.controller;

import com.toolbox.toolbox.Domain.repository.SubjectRepository;
import com.toolbox.toolbox.persistance.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;
    @PostMapping("/add")
    public void addSubject(@RequestBody Subject subject){
        subjectRepository.save(subject);

    }
}
