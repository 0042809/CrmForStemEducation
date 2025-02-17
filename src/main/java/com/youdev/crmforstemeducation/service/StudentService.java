package com.youdev.crmforstemeducation.service;

import com.youdev.crmforstemeducation.model.Student;
import com.youdev.crmforstemeducation.repository.StudentRepository;
import com.youdev.crmforstemeducation.exception.ResourceNotFoundException;
import com.youdev.crmforstemeducation.dto.StudentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student, Long> {
    private final StudentRepository studentRepository;
    private final UserService userService;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student createStudent(StudentDto studentDTO) {
        Student student = new Student();
        student.setUser(userService.findById(studentDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found")));
        student.setFullName(studentDTO.getFullName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());

        return save(student);
    }

    @Transactional
    public Student update(Long id, StudentDto studentDTO) {
        Student student = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        student.setFullName(studentDTO.getFullName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());


        return save(student);
    }

    @Override
    public void delete(Long id) {
        if (!exists(id)) {
            throw new ResourceNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return studentRepository.existsById(id);
    }

    public List<Student> findByGroupId(Long groupId) {
        return studentRepository.findB
        GroupId(groupId);
    }
}