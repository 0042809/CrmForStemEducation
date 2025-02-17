package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher, Long> {
    List<Teacher> findBySpecialization(String specialization);

    @Query("SELECT t FROM Teacher t WHERE t.status = 'ACTIVE'")
    List<Teacher> findAllActiveTeachers();

    @Query("SELECT t FROM Teacher t JOIN t.subjects s WHERE s.id = :subjectId")
    List<Teacher> findBySubjectId(Long subjectId);

    @Query("SELECT t FROM Teacher t WHERE t.experience >= :years")
    List<Teacher> findByExperienceGreaterThan(Integer years);

    boolean existsByPhoneNumber(String phoneNumber);
}
