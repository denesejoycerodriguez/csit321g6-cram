package com.csit321g6.cramdelacram.cram.repository;

import com.csit321g6.cramdelacram.cram.entity.Topic;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByCourseId(Long courseId);
}