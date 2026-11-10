package com.csit321g6.cramdelacram.cram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csit321g6.cramdelacram.cram.entity.TopicProgress;
import com.csit321g6.cramdelacram.cram.repository.TopicProgressRepository;

@Service
public class TopicProgressService {

    private final TopicProgressRepository topicProgressRepository;

    public TopicProgressService(TopicProgressRepository topicProgressRepository) {
        this.topicProgressRepository = topicProgressRepository;
    }

    public TopicProgress createTopicProgress(TopicProgress progress) {
        return topicProgressRepository.save(progress);
    }

    public List<TopicProgress> getAllTopicProgress() {
        return topicProgressRepository.findAll();
    }

    public TopicProgress getTopicProgressById(Long id) {
        return topicProgressRepository.findById(id).orElse(null);
    }

    public TopicProgress updateTopicProgress(Long id, TopicProgress progressDetails) {
        TopicProgress progress = getTopicProgressById(id);

        if (progress == null) {
            return null;
        }

        progress.setUser(progressDetails.getUser());
        progress.setTopic(progressDetails.getTopic());
        progress.setMasteryLevel(progressDetails.getMasteryLevel());
        progress.setLastReviewed(progressDetails.getLastReviewed());

        return topicProgressRepository.save(progress);
    }

    public void deleteTopicProgress(Long id) {
        topicProgressRepository.deleteById(id);
    }
}
