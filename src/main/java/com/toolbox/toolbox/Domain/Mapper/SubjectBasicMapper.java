package com.toolbox.toolbox.Domain.Mapper;

import com.toolbox.toolbox.Domain.DTO.SubjectBasicDTO;
import com.toolbox.toolbox.persistance.entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectBasicMapper {
    SubjectBasicDTO toDto(Subject subject);

    Subject toEntity(SubjectBasicDTO subjectBasicDTO);
}
