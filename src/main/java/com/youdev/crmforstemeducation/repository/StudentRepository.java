package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
