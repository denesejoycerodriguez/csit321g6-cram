package com.csit321g6.cramdelacram.cram.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="STUDY_REMINDER")
public class StudyReminderEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private ExamEntity exam; 

    private LocalDateTime reminderTime;
    private String message; 

    public StudyReminderEntity() {}

    public StudyReminderEntity(Long reminderId, UserEntity user, ExamEntity exam, LocalDateTime reminderTime, String message) {
        this.reminderId = reminderId;
        this.user = user;
        this.exam = exam;
        this.reminderTime = reminderTime;
        this.message = message;
    }

    public Long getReminderId() { return reminderId; }
    public void setReminderId(Long reminderId) { this.reminderId = reminderId; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

    public ExamEntity getExam() { return exam; }
    public void setExam(ExamEntity exam) { this.exam = exam; }

    public LocalDateTime getReminderTime() { return reminderTime; }
    public void setReminderTime(LocalDateTime reminderTime) { this.reminderTime = reminderTime; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}