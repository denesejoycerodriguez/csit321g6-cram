package com.csit321g6.cramdelacram.cram.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "flashcard")
public class FlashcardEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "topic_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TopicEntity topic;
    @NotBlank @Column(nullable = false, length = 500)
    private String question;
    @NotBlank @Column(nullable = false, length = 1000)
    private String answer;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TopicEntity getTopic() { return topic; }
    public void setTopic(TopicEntity topic) { this.topic = topic; }
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}