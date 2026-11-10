package com.csit321g6.cramdelacram.cram.entity;

import jakarta.persistence.*;

@Entity
@Table(name="SESSION_TOPIC")
public class SessionTopicEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionTopicId; 

    @ManyToOne
    @JoinColumn(name = "session_id")
    private StudySessionEntity studySession;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicEntity topic; 

    private Integer allottedMinutes; 

    public SessionTopicEntity() {}

    public SessionTopicEntity(Long sessionTopicId, StudySessionEntity studySession, TopicEntity topic, Integer allottedMinutes) {
        this.sessionTopicId = sessionTopicId;
        this.studySession = studySession;
        this.topic = topic;
        this.allottedMinutes = allottedMinutes;
    }

    public Long getSessionTopicId() { return sessionTopicId; }
    public void setSessionTopicId(Long sessionTopicId) { this.sessionTopicId = sessionTopicId; }

    public StudySessionEntity getStudySession() { return studySession; }
    public void setStudySession(StudySessionEntity studySession) { this.studySession = studySession; }

    public TopicEntity getTopic() { return topic; }
    public void setTopic(TopicEntity topic) { this.topic = topic; }

    public Integer getAllottedMinutes() { return allottedMinutes; }
    public void setAllottedMinutes(Integer allottedMinutes) { this.allottedMinutes = allottedMinutes; }
}