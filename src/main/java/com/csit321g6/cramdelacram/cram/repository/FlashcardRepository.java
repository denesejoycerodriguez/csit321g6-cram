package com.csit321g6.cramdelacram.cram.repository;

import com.csit321g6.cramdelacram.cram.entity.Flashcard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findByTopicId(Long topicId);
}