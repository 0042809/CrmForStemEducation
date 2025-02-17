package com.youdev.crmforstemeducation.service;

import com.youdev.crmforstemeducation.dto.LessonDto;
import com.youdev.crmforstemeducation.exception.ResourceNotFoundException;
import com.youdev.crmforstemeducation.model.Lesson;
import com.youdev.crmforstemeducation.model.Student;
import com.youdev.crmforstemeducation.model.Teacher;
import com.youdev.crmforstemeducation.repository.LessonRepository;
import com.youdev.crmforstemeducation.repository.StudentRepository;
import com.youdev.crmforstemeducation.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LessonService {

    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final LessonMapper lessonMapper;

    public List<LessonDto> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    public Lesson getLessonById(Long id) {
        return lessonMapper.toDto(findLessonById(id));
    }

    @Transactional
    public LessonDto createLesson(Lesson lessonDto) {
        Teacher teacher = findTeacherById(lessonDto.getTeacherId());
        Student student = findStudentById(lessonDto.getStudentId());

        validateLessonTime(lessonDto, teacher);

        Lesson lesson = lessonMapper.toEntity(lessonDto, teacher, student);
        lesson = lessonRepository.save(lesson);

        return lessonMapper.toDto(lesson);
    }

    @Transactional
    public LessonDto updateLesson(Long id, LessonDto lessonDto) {
        Lesson existingLesson = findLessonById(id);
        Teacher teacher = findTeacherById(lessonDto.getTeacherId());
        Student student = findStudentById(lessonDto.getStudentId());

        validateLessonTime(lessonDto, teacher);

        Lesson updatedLesson = lessonMapper.toEntity(lessonDto, teacher, student);
        updatedLesson.setId(id);
        updatedLesson = lessonRepository.save(updatedLesson);

        return lessonMapper.toDto(updatedLesson);
    }

    @Transactional
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lesson not found with id: " + id);
        }
        lessonRepository.deleteById(id);
    }

    @Transactional
    public LessonDto updateLessonStatus(Long id, Lesson.LessonStatus status) {
        Lesson lesson = findLessonById(id);
        lesson.setStatus(status);
        return lessonMapper.toDto(lessonRepository.save(lesson));
    }

    @Transactional
    public void markAttendance(Long lessonId, Long studentId, boolean isPresent) {
        Lesson lesson = findLessonById(lessonId);
        Student student = findStudentById(studentId);

        if (!lesson.getStudent().getId().equals(student.getId())) {
            throw new IllegalArgumentException("Student is not enrolled in this lesson");
        }

        lesson.getAttendance().put(studentId, isPresent);
        lessonRepository.save(lesson);
    }

    public List<LessonDto> getTeacherLessons(Long teacherId, LocalDateTime start, LocalDateTime end) {
        Teacher teacher = findTeacherById(teacherId);
        return lessonRepository.findByTeacherAndStartTimeBetweenOrderByStartTimeAsc(teacher, start, end)
                .stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<LessonDto> getStudentLessons(Long studentId, LocalDateTime start, LocalDateTime end) {
        Student student = findStudentById(studentId);
        return lessonRepository.findByStudentAndStartTimeBetweenOrderByStartTimeAsc(student, start, end)
                .stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    private Lesson findLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));
    }

    private Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
    }

    private Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    private void validateLessonTime(LessonDto lessonDto, Teacher teacher) {
        if (lessonDto.getStartTime().isAfter(lessonDto.getEndTime())) {
            throw new IllegalArgumentException("Lesson start time must be before end time");
        }

        List<Lesson> overlappingLessons = lessonRepository.findOverlappingLessons(
                teacher.getId(),
                lessonDto.getStartTime(),
                lessonDto.getEndTime()
        );

        if (!overlappingLessons.isEmpty()) {
            throw new IllegalArgumentException("Teacher has conflicting lessons at this time");
        }
    }
}