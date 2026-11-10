package com.csit321g6.cramdelacram.cram.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="EXAM")
public class ExamEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    private Long userId;
    private Long courseId;
    private String examTitle;
    private LocalDateTime examDate;

    public ExamEntity(){}

    public ExamEntity(Long examId, Long userId, Long courseId, String examTitle, LocalDateTime examDate){
        this.examId = examId;
        this.userId = userId;
        this.courseId = courseId;
        this.examTitle = examTitle;
        this.examDate = examDate;
    }

    public Long getExamId(){ return examId; }
    public void setExamId(Long examId){ this.examId = examId; }

    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId = userId; }

    public Long getCourseId(){ return courseId; }
    public void setCourseId(Long courseId){ this.courseId = courseId; }

    public String getExamTitle(){ return examTitle; }
    public void setExamTitle(String examTitle){ this.examTitle = examTitle; }

    public LocalDateTime getExamDate(){ return examDate; }
    public void setExamDate(LocalDateTime examDate){ this.examDate = examDate; }
}
