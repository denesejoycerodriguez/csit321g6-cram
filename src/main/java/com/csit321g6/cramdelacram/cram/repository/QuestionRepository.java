package com.csit321g6.cramdelacram.cram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csit321g6.cramdelacram.cram.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
