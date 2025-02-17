package com.youdev.crmforstemeducation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Set;
import com.youdev.crmforstemeducation.model.enums.TeacherStatus;

@Entity
@Table(name = "teachers")
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String fullName;

    private String phoneNumber;

    @Column(nullable = false)
    private String specialization;

    private Integer experience;

    private String qualification;

    @Enumerated(EnumType.STRING)
    private TeacherStatus status = TeacherStatus.ACTIVE;

    @OneToMany(mappedBy = "teacher")
    private Set<Group> groups;

    @OneToMany(mappedBy = "teacher")
    private Set<Lesson> lessons;

    @ManyToMany
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;
}