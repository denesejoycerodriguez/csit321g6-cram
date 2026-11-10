package com.csit321g6.cramdelacram.cram.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.csit321g6.cramdelacram.cram.entity.ReviewPriority;
import com.csit321g6.cramdelacram.cram.repository.ReviewPriorityRepository;

@Service
public class ReviewPriorityService {

    private final ReviewPriorityRepository reviewPriorityRepository;

    public ReviewPriorityService(ReviewPriorityRepository reviewPriorityRepository) {
        this.reviewPriorityRepository = reviewPriorityRepository;
    }

    public ReviewPriority createReviewPriority(ReviewPriority priority) {
        return reviewPriorityRepository.save(priority);
    }

    public List<ReviewPriority> getAllReviewPriorities() {
        return reviewPriorityRepository.findAll();
    }

    public ReviewPriority getReviewPriorityById(Long id) {
        return reviewPriorityRepository.findById(id).orElse(null);
    }

    public ReviewPriority updateReviewPriority(Long id, ReviewPriority priorityDetails) {
        ReviewPriority priority = getReviewPriorityById(id);

        if (priority == null) {
            return null;
        }

        priority.setUser(priorityDetails.getUser());
        priority.setTopic(priorityDetails.getTopic());
        priority.setExam(priorityDetails.getExam());
        priority.setPriorityLevel(priorityDetails.getPriorityLevel());

        return reviewPriorityRepository.save(priority);
    }

    public void deleteReviewPriority(Long id) {
        reviewPriorityRepository.deleteById(id);
    }
}
