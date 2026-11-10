package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g6.cramdelacram.cram.entity.ReviewPriority;
import com.csit321g6.cramdelacram.cram.service.ReviewPriorityService;

@RestController
@RequestMapping("/api/review-priorities")
@CrossOrigin(origins = "*")
public class ReviewPriorityController {

    private final ReviewPriorityService reviewPriorityService;

    public ReviewPriorityController(ReviewPriorityService reviewPriorityService) {
        this.reviewPriorityService = reviewPriorityService;
    }

    @PostMapping
    public ReviewPriority createReviewPriority(@RequestBody ReviewPriority priority) {
        return reviewPriorityService.createReviewPriority(priority);
    }

    @GetMapping
    public List<ReviewPriority> getAllReviewPriorities() {
        return reviewPriorityService.getAllReviewPriorities();
    }

    @GetMapping("/{id}")
    public ReviewPriority getReviewPriorityById(@PathVariable Long id) {
        return reviewPriorityService.getReviewPriorityById(id);
    }

    @PutMapping("/{id}")
    public ReviewPriority updateReviewPriority(
            @PathVariable Long id,
            @RequestBody ReviewPriority priority) {
        return reviewPriorityService.updateReviewPriority(id, priority);
    }

    @DeleteMapping("/{id}")
    public void deleteReviewPriority(@PathVariable Long id) {
        reviewPriorityService.deleteReviewPriority(id);
    }
}
