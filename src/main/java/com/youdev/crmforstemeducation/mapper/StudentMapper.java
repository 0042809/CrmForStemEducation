package com.youdev.crmforstemeducation.mapper;
import com.youdev.crmforstemeducation.dto.StudentDTO;
import com.youdev.crmforstemeducation.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "user", ignore = true)
    StudentDTO toDTO(Student student);

    @Mapping(target = "user", ignore = true)
    Student toEntity(StudentDTO studentDTO);

    void updateStudentFromDTO(StudentDTO studentDTO, @MappingTarget Student student);
}