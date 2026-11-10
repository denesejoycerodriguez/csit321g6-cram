package com.csit321g6.cramdelacram.cram.repository;

import com.csit321g6.cramdelacram.cram.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUserId(Long userId);
}