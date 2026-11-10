package com.csit321g6.cramdelacram.cram.entity;

import jakarta.persistence.*;

@Entity
@Table(name="SESSION_TOPIC")
public class SessionTopicEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;
    private Long sessionId;
    private String topicName;
    private String notes;
    private boolean completed;

    public SessionTopicEntity() {}

    public SessionTopicEntity(Long topicId, Long sessionId, String topicName, String notes, boolean completed) {
        this.topicId = topicId;
        this.sessionId = sessionId;
        this.topicName = topicName;
        this.notes = notes;
        this.completed = completed;
    }

    public Long getTopicId() { return topicId; }
    public void setTopicId(Long topicId) { this.topicId = topicId; }

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}