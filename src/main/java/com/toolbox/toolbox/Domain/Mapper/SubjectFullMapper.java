package com.toolbox.toolbox.Domain.Mapper;
import com.toolbox.toolbox.Domain.DTO.SubjectFullDTO;
import com.toolbox.toolbox.persistance.entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface  SubjectFullMapper {

    SubjectFullDTO toDto(Subject subject);

    Subject toEntity(SubjectFullDTO subjectFullDTO);
}
