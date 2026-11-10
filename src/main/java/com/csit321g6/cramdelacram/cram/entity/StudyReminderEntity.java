package com.csit321g6.cramdelacram.cram.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="STUDY_REMINDER")
public class StudyReminderEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderId;
    private Long userId;
    private Long courseId;
    private String reminderMessage;
    private LocalDateTime reminderTime;
    private boolean sent;

    public StudyReminderEntity() {}

    public StudyReminderEntity(Long reminderId, Long userId, Long courseId, String reminderMessage, LocalDateTime reminderTime, boolean sent) {
        this.reminderId = reminderId;
        this.userId = userId;
        this.courseId = courseId;
        this.reminderMessage = reminderMessage;
        this.reminderTime = reminderTime;
        this.sent = sent;
    }

    public Long getReminderId() { return reminderId; }
    public void setReminderId(Long reminderId) { this.reminderId = reminderId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getReminderMessage() { return reminderMessage; }
    public void setReminderMessage(String reminderMessage) { this.reminderMessage = reminderMessage; }

    public LocalDateTime getReminderTime() { return reminderTime; }
    public void setReminderTime(LocalDateTime reminderTime) { this.reminderTime = reminderTime; }

    public boolean isSent() { return sent; }
    public void setSent(boolean sent) { this.sent = sent; }
}