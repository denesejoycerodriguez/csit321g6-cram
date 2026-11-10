package com.csit321g6.cramdelacram.cram.service;

import org.springframework.stereotype.Service;
import com.csit321g6.cramdelacram.cram.entity.SessionTopicEntity;
import com.csit321g6.cramdelacram.cram.repository.SessionTopicRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SessionTopicService {
    final SessionTopicRepository topicRepo;

    SessionTopicService(SessionTopicRepository topicRepo) {
        this.topicRepo = topicRepo;
    }

    public SessionTopicEntity createTopic(SessionTopicEntity topic) {
        return topicRepo.save(topic);
    }

    public List<SessionTopicEntity> getAllTopics() {
        return topicRepo.findAll();
    }

    public SessionTopicEntity updateTopic(Long id, SessionTopicEntity details) {
        SessionTopicEntity topic = new SessionTopicEntity();
        try {
            topic = topicRepo.findById(id).get();
            topic.setSessionId(details.getSessionId());
            topic.setTopicName(details.getTopicName());
            topic.setNotes(details.getNotes());
            topic.setCompleted(details.isCompleted());
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Session Topic " + id + " does not exist!");
        }
        return topicRepo.save(topic);
    }

    public String deleteTopic(Long id) {
        String msg = "";
        if (topicRepo.findById(id).isPresent()) {
            topicRepo.deleteById(id);
            msg = "Session Topic is successfully deleted!";
        } else {
            msg = "Session Topic does not exist!";
        }
        return msg;
    }
}