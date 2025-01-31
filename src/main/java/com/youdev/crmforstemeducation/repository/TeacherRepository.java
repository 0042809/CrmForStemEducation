package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
