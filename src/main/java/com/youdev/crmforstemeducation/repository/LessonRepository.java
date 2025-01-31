package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
