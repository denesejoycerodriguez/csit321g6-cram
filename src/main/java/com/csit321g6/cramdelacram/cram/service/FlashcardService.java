package com.csit321g6.cramdelacram.cram.service;

import com.csit321g6.cramdelacram.cram.entity.Flashcard;
import com.csit321g6.cramdelacram.cram.entity.Topic;
import com.csit321g6.cramdelacram.cram.repository.FlashcardRepository;
import com.csit321g6.cramdelacram.cram.repository.TopicRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class FlashcardService {

    private final FlashcardRepository flashcards;
    private final TopicRepository topics;

    public FlashcardService(FlashcardRepository flashcards, TopicRepository topics) {
        this.flashcards = flashcards;
        this.topics = topics;
    }

    public Flashcard create(Flashcard f) {
        f.setId(null);
        f.setTopic(findTopic(f.getTopic()));
        return flashcards.save(f);
    }

    @Transactional(readOnly = true)
    public List<Flashcard> getAll(Long topicId) {
        return topicId == null ? flashcards.findAll() : flashcards.findByTopicId(topicId);
    }

    @Transactional(readOnly = true)
    public Flashcard getById(Long id) {
        return flashcards.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard " + id + " not found"));
    }

    public Flashcard update(Long id, Flashcard in) {
        Flashcard f = getById(id);
        f.setQuestion(in.getQuestion());
        f.setAnswer(in.getAnswer());
        if (in.getTopic() != null && in.getTopic().getId() != null)
            f.setTopic(findTopic(in.getTopic()));
        return flashcards.save(f);
    }

    public void delete(Long id) {
        flashcards.delete(getById(id));
    }

    private Topic findTopic(Topic ref) {
        if (ref == null || ref.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "topic.id is required");
        return topics.findById(ref.getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic " + ref.getId() + " not found"));
    }
}