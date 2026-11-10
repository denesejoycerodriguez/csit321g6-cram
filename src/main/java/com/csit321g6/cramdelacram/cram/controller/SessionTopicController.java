package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.csit321g6.cramdelacram.cram.entity.SessionTopicEntity;
import com.csit321g6.cramdelacram.cram.service.SessionTopicService;

@RestController
@RequestMapping("/api/session-topics")
public class SessionTopicController {
    final SessionTopicService topicService;

    SessionTopicController(SessionTopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public SessionTopicEntity createTopic(@RequestBody SessionTopicEntity topic) {
        return topicService.createTopic(topic);
    }

    @GetMapping
    public List<SessionTopicEntity> getAllTopics() {
        return topicService.getAllTopics();
    }

    @PutMapping("/{id}")
    public SessionTopicEntity updateTopic(@PathVariable Long id, @RequestBody SessionTopicEntity details) {
        return topicService.updateTopic(id, details);
    }

    @DeleteMapping("/{id}")
    public String deleteTopic(@PathVariable Long id) {
        return topicService.deleteTopic(id);
    }
}