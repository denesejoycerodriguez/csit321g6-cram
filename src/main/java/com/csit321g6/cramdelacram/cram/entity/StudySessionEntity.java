package com.csit321g6.cramdelacram.cram.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="STUDY_SESSION")
public class StudySessionEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private ExamEntity exam; 

    private LocalDateTime sessionDate; 
    private Integer durationMinutes;

    public StudySessionEntity() {}

    public StudySessionEntity(Long sessionId, UserEntity user, ExamEntity exam, LocalDateTime sessionDate, Integer durationMinutes) {
        this.sessionId = sessionId;
        this.user = user;
        this.exam = exam;
        this.sessionDate = sessionDate;
        this.durationMinutes = durationMinutes;
    }

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

    public ExamEntity getExam() { return exam; }
    public void setExam(ExamEntity exam) { this.exam = exam; }

    public LocalDateTime getSessionDate() { return sessionDate; }
    public void setSessionDate(LocalDateTime sessionDate) { this.sessionDate = sessionDate; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }
}