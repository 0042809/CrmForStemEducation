package com.youdev.crmforstemeducation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Set;
import com.youdev.crmforstemeducation.model.enums.GroupStatus;

@Entity
@Table(name = "groups")
@Data
@EqualsAndHashCode(callSuper = true)
public class Group extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private Integer maxStudents;

    @Enumerated(EnumType.STRING)
    private GroupStatus status = GroupStatus.ACTIVE;
}