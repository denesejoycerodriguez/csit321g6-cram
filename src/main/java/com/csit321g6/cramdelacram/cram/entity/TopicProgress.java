package com.csit321g6.cramdelacram.cram.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_progress")
public class TopicProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long progressId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @Column(name = "mastery_level")
    private String masteryLevel;

    @Column(name = "last_reviewed")
    private LocalDateTime lastReviewed;

    public TopicProgress() {
    }

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getMasteryLevel() {
        return masteryLevel;
    }

    public void setMasteryLevel(String masteryLevel) {
        this.masteryLevel = masteryLevel;
    }

    public LocalDateTime getLastReviewed() {
        return lastReviewed;
    }

    public void setLastReviewed(LocalDateTime lastReviewed) {
        this.lastReviewed = lastReviewed;
    }
}
