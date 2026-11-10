package com.csit321g6.cramdelacram.cram.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class ReviewMaterial {
    public enum Type { NOTE, SUMMARY, REVIEWER, LINK }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "topic_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Topic topic;
    @NotBlank @Column(nullable = false)
    private String title;
    @NotNull @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Type type;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String resourceUrl;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Topic getTopic() { return topic; }
    public void setTopic(Topic topic) { this.topic = topic; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getResourceUrl() { return resourceUrl; }
    public void setResourceUrl(String resourceUrl) { this.resourceUrl = resourceUrl; }
}