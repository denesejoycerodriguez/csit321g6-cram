package com.csit321g6.cramdelacram.cram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csit321g6.cramdelacram.cram.entity.ReviewPriority;

@Repository
public interface ReviewPriorityRepository extends JpaRepository<ReviewPriority, Long> {

}
