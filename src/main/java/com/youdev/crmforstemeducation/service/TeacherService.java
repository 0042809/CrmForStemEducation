package com.youdev.crmforstemeducation.service;

import com.youdev.crmforstemeducation.model.Teacher;
import com.youdev.crmforstemeducation.repository.TeacherRepository;
import com.youdev.crmforstemeducation.exception.ResourceNotFoundException;
import com.youdev.crmforstemeducation.dto.TeacherDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService implements BaseService<Teacher, Long> {
    private final TeacherRepository teacherRepository;
    private final UserService userService;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Transactional
    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setUser(userService.findById(teacherDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found")));
        teacher.setFullName(teacherDTO.getFullName());
        teacher.setPhoneNumber(teacherDTO.getPhoneNumber());

        return save(teacher);
    }

    @Transactional
    public Teacher update(Long id, TeacherDTO teacherDTO) {
        Teacher teacher = findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        teacher.setFullName(teacherDTO.getFullName());
        teacher.setPhoneNumber(teacherDTO.getPhoneNumber());


        return save(teacher);
    }

    @Override
    public void delete(Long id) {
        if (!exists(id)) {
            throw new ResourceNotFoundException("Teacher not found");
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return teacherRepository.existsById(id);
    }
}