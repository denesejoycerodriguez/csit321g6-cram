package com.csit321g6.cramdelacram.cram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csit321g6.cramdelacram.cram.entity.StudySessionEntity;

public interface StudySessionRepository extends JpaRepository<StudySessionEntity, Long> {
}