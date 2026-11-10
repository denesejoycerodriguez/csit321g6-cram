package com.csit321g6.cramdelacram.cram.repository;

import com.csit321g6.cramdelacram.cram.entity.FlashcardEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<FlashcardEntity, Long> {
    List<FlashcardEntity> findByTopicId(Long topicId);
}