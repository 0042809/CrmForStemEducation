package com.youdev.crmforstemeducation.mapper;

import com.youdev.crmforstemeducation.dto.LessonDTO;
import com.youdev.crmforstemeducation.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "students", ignore = true)

    LessonDTO toDTO(LessonDTO lesson);

    Lesson toEntity(LessonDTO lessonDTO);
}
