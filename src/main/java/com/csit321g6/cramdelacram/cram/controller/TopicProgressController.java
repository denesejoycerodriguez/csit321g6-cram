package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g6.cramdelacram.cram.entity.TopicProgress;
import com.csit321g6.cramdelacram.cram.service.TopicProgressService;

@RestController
@RequestMapping("/api/topic-progress")
@CrossOrigin(origins = "*")
public class TopicProgressController {

    private final TopicProgressService topicProgressService;

    public TopicProgressController(TopicProgressService topicProgressService) {
        this.topicProgressService = topicProgressService;
    }

    @PostMapping
    public TopicProgress createTopicProgress(@RequestBody TopicProgress progress) {
        return topicProgressService.createTopicProgress(progress);
    }

    @GetMapping
    public List<TopicProgress> getAllTopicProgress() {
        return topicProgressService.getAllTopicProgress();
    }

    @GetMapping("/{id}")
    public TopicProgress getTopicProgressById(@PathVariable Long id) {
        return topicProgressService.getTopicProgressById(id);
    }

    @PutMapping("/{id}")
    public TopicProgress updateTopicProgress(
            @PathVariable Long id,
            @RequestBody TopicProgress progress) {
        return topicProgressService.updateTopicProgress(id, progress);
    }

    @DeleteMapping("/{id}")
    public void deleteTopicProgress(@PathVariable Long id) {
        topicProgressService.deleteTopicProgress(id);
    }
}
