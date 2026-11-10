package com.csit321g6.cramdelacram.cram.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "topic")
public class TopicEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "course_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CourseEntity course;
    @NotBlank @Column(nullable = false)
    private String title;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CourseEntity getCourse() { return course; }
    public void setCourse(CourseEntity course) { this.course = course; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}