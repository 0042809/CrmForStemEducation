package com.youdev.crmforstemeducation.controller;

import com.youdev.crmforstemeducation.dto.StudentDTO;
import com.youdev.crmforstemeducation.mapper.StudentMapper;
import com.youdev.crmforstemeducation.model.Student;
import com.youdev.crmforstemeducation.model.User;
import com.youdev.crmforstemeducation.repository.StudentRepository;
import com.youdev.crmforstemeducation.repository.UserRepository;
import com.youdev.crmforstemeducation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents().stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'STUDENT')")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentMapper.toDTO(studentService.getStudentById(id)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = studentService.createStudent(studentMapper.toEntity(studentDTO));
        return new ResponseEntity<>(studentMapper.toDTO(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDTO studentDTO) {
        Student student = studentService.updateStudent(id, studentMapper.toEntity(studentDTO));
        return ResponseEntity.ok(studentMapper.toDTO(student));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}