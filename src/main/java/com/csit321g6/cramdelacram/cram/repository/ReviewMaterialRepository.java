package com.csit321g6.cramdelacram.cram.repository;

import com.csit321g6.cramdelacram.cram.entity.ReviewMaterial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewMaterialRepository extends JpaRepository<ReviewMaterial, Long> {
    List<ReviewMaterial> findByTopicId(Long topicId);
}