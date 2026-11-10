package com.csit321g6.cramdelacram.cram.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="STUDY_SESSION")
public class StudySessionEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    private Long userId;
    private Long courseId;
    private String sessionTitle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public StudySessionEntity() {}

    public StudySessionEntity(Long sessionId, Long userId, Long courseId, String sessionTitle, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.courseId = courseId;
        this.sessionTitle = sessionTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getSessionTitle() { return sessionTitle; }
    public void setSessionTitle(String sessionTitle) { this.sessionTitle = sessionTitle; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}