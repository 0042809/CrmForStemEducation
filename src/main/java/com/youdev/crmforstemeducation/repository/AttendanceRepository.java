package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends BaseRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);

    List<Attendance> findByLessonId(Long lessonId);

    @Query("SELECT a FROM Attendance a WHERE a.student.id = :studentId AND " +
            "a.lesson.startTime BETWEEN :startDate AND :endDate")
    List<Attendance> findStudentAttendanceInPeriod(Long studentId,
                                                   LocalDateTime startDate,
                                                   LocalDateTime endDate);

    @Query("SELECT COUNT(a) FROM Attendance a WHERE a.student.id = :studentId AND " +
            "a.status = 'PRESENT' AND a.lesson.id = :lessonId")
    int countStudentPresenceInLesson(Long studentId, Long lessonId);
}
