package com.toolbox.toolbox.service;

import com.toolbox.toolbox.Domain.repository.SubjectRepository;
import com.toolbox.toolbox.persistance.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    SubjectRepository  subjectRepository;
    @Autowired
    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> findById(String id) {
        return subjectRepository.findById(id);
    }

    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

}
