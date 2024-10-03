package com.toolbox.toolbox.service;

import com.toolbox.toolbox.Domain.DTO.SubjectFullDTO;
import com.toolbox.toolbox.Domain.Mapper.SubjectFullMapper;
import com.toolbox.toolbox.Domain.repository.SubjectRepository;
import com.toolbox.toolbox.persistance.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectFullService {
    private final SubjectFullMapper subjectFullMapper;
    SubjectRepository  subjectRepository;
    @Autowired
    public SubjectFullService(SubjectRepository subjectRepository, SubjectFullMapper subjectFullMapper){
        this.subjectRepository = subjectRepository;
        this.subjectFullMapper = subjectFullMapper;
    }

    public List<SubjectFullDTO> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(subjectFullMapper::toDto)
                .collect(Collectors.toList());
    }

    public SubjectFullDTO getSubjectById(String id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        return subject != null ? subjectFullMapper.toDto(subject) : null;
    }

    public SubjectFullDTO createSubject(SubjectFullDTO subjectDTO) {
        Subject subject = subjectFullMapper.toEntity(subjectDTO);
        Subject savedSubject = subjectRepository.save(subject);
        return subjectFullMapper.toDto(savedSubject);
    }
    public void deleteSubject(String id) {
        subjectRepository.deleteById(id);
    }

}
