package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LessonRepository extends BaseRepository<Lesson, Long> {
    List<Lesson> findByTeacherId(Long teacherId);

    List<Lesson> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT l FROM Lesson l WHERE l.room = :room AND " +
            "((l.startTime <= :endTime AND l.endTime >= :startTime))")
    List<Lesson> findOverlappingLessons(String room, LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT l FROM Lesson l WHERE l.teacher.id = :teacherId AND " +
            "l.startTime >= :start AND l.endTime <= :end")
    List<Lesson> findTeacherLessonsInPeriod(Long teacherId, LocalDateTime start, LocalDateTime end);

    @Query("SELECT COUNT(l) FROM Lesson l WHERE l.teacher.id = :teacherId AND " +
            "FUNCTION('DATE', l.startTime) = FUNCTION('DATE', :date)")
    int countTeacherLessonsPerDay(Long teacherId, LocalDateTime date);
}