package com.youdev.crmforstemeducation.model;

import com.youdev.crmforstemeducation.model.enums.TestStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tests")
@Data
@EqualsAndHashCode(callSuper = true)
public class Test extends BaseEntity {
    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    private Integer duration; // minutes

    private Integer maxScore;

    private Integer passingScore;

    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private TestStatus status = TestStatus.DRAFT;

    @OneToMany(mappedBy = "test")
    private Set<TestResult> results;
}