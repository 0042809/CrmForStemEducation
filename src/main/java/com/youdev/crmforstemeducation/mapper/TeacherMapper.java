package com.youdev.crmforstemeducation.mapper;

import com.youdev.crmforstemeducation.dto.TeacherDTO;
import com.youdev.crmforstemeducation.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target="user", ignore = true)
    Teacher toDTO(Teacher teacher);

    @Mapping(target="user", ignore = true)
    TeacherDTO toEntity(TeacherDTO teacherDTO);
    void updateTeacherFromDTO(TeacherDTO teacherDTO, @MappingTarget Teacher teacher);
}
