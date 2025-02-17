package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Student;
import com.youdev.crmforstemeducation.model.enums.StudentStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends BaseRepository<Student, Long> {
    List<Student> findByGroupId(Long groupId);

    @Query("SELECT s FROM Student s WHERE s.group.teacher.id = :teacherId")
    List<Student> findByTeacherId(Long teacherId);

    List<Student> findByStatus(StudentStatus status);

    @Query("SELECT s FROM Student s JOIN s.lessons l WHERE l.id = :lessonId")
    List<Student> findByLessonId(Long lessonId);

    @Query("SELECT COUNT(s) > 0 FROM Student s WHERE s.phoneNumber = :phoneNumber")
    boolean existsByPhoneNumber(String phoneNumber);
}