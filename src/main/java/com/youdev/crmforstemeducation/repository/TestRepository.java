package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestRepository extends BaseRepository<Test, Long> {
    List<Test> findBySubjectId(Long subjectId);

    @Query("SELECT t FROM Test t WHERE t.subject.teacher.id = :teacherId")
    List<Test> findByTeacherId(Long teacherId);

    @Query("SELECT t FROM Test t WHERE t.status = :status")
    List<Test> findByStatus(String status);

    @Query("SELECT t FROM Test t WHERE t.dueDate > CURRENT_TIMESTAMP")
    List<Test> findActiveTests();

    @Query("SELECT t FROM Test t JOIN t.submissions s WHERE s.student.id = :studentId")
    List<Test> findTestsByStudentId(Long studentId);
}