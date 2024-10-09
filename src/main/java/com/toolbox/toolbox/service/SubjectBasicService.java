package com.toolbox.toolbox.service;

import com.toolbox.toolbox.Domain.DTO.SubjectBasicDTO;
import com.toolbox.toolbox.Domain.Mapper.SubjectBasicMapper;
import com.toolbox.toolbox.persistance.repository.SubjectRepository;
import com.toolbox.toolbox.persistance.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectBasicService {
    private final SubjectBasicMapper subjectBasicMapper;
    SubjectRepository subjectRepository;
    @Autowired
    public SubjectBasicService(SubjectRepository subjectRepository, SubjectBasicMapper subjectBasicMapper){
        this.subjectRepository = subjectRepository;
        this.subjectBasicMapper = subjectBasicMapper;
    }

    public List<SubjectBasicDTO> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(subjectBasicMapper::toDto)
                .toList();

    }

    public SubjectBasicDTO getSubjectById(String id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        return subject != null ? subjectBasicMapper.toDto(subject) : null;
    }
}
