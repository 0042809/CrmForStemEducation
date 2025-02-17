package com.youdev.crmforstemeducation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Set;

@Entity
@Table(name = "subjects")
@Data
@EqualsAndHashCode(callSuper = true)
public class Subject extends BaseEntity {
    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "subjects")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "subject")
    private Set<Group> groups;

    @OneToMany(mappedBy = "subject")
    private Set<Test> tests;
}