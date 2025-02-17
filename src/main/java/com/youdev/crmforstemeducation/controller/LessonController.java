package com.youdev.crmforstemeducation.controller;

import com.youdev.crmforstemeducation.dto.LessonDTO;
import com.youdev.crmforstemeducation.mapper.LessonMapper;
import com.youdev.crmforstemeducation.model.Lesson;
import com.youdev.crmforstemeducation.service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final LessonMapper lessonMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'STUDENT')")
    public ResponseEntity<List<LessonDTO>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons().stream()
                .map(lessonMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'STUDENT')")
    public ResponseEntity<LessonDTO> getLessonById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonMapper.toDTO(lessonService.getLessonById(id)));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<LessonDTO> createLesson(@Valid @RequestBody LessonDTO lessonDTO) {
        LessonDTO lesson = lessonService.createLesson(lessonMapper.toEntity(lessonDTO));
        return new ResponseEntity<>(lessonMapper.toDTO(lesson), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<LessonDTO> updateLesson(
            @PathVariable Long id,
            @Valid @RequestBody LessonDTO lessonDTO) {
        Lesson lesson = lessonService.updateLesson(id, lessonMapper.toEntity(lessonDTO));
        return ResponseEntity.ok(lessonMapper.toDTO(lesson));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}