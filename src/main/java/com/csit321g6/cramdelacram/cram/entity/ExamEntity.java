package com.csit321g6.cramdelacram.cram.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="EXAM")
public class ExamEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    private String examTitle;
    private LocalDateTime examDate;

    public ExamEntity(){}

    public ExamEntity(Long examId, UserEntity user, CourseEntity course, String examTitle, LocalDateTime examDate){
        this.examId = examId;
        this.user = user;
        this.course = course;
        this.examTitle = examTitle;
        this.examDate = examDate;
    }

    public Long getExamId(){ return examId; }
    public void setExamId(Long examId){ this.examId = examId; }

    public UserEntity getUser(){ return user; }
    public void setUser(UserEntity user){ this.user = user; }

    public CourseEntity getCourse(){ return course; }
    public void setCourse(CourseEntity course){ this.course = course; }

    public String getExamTitle(){ return examTitle; }
    public void setExamTitle(String examTitle){ this.examTitle = examTitle; }

    public LocalDateTime getExamDate(){ return examDate; }
    public void setExamDate(LocalDateTime examDate){ this.examDate = examDate; }
}