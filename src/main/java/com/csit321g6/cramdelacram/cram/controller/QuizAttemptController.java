package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.csit321g6.cramdelacram.cram.entity.QuizAttempt;
import com.csit321g6.cramdelacram.cram.service.QuizAttemptService;

@RestController
@RequestMapping("/api/quiz-attempts")
@CrossOrigin(origins = "*")
public class QuizAttemptController {

    private final QuizAttemptService quizAttemptService;

    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    @PostMapping
    public QuizAttempt createQuizAttempt(@RequestBody QuizAttempt attempt) {
        return quizAttemptService.createQuizAttempt(attempt);
    }

    @GetMapping
    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptService.getAllQuizAttempts();
    }

    @GetMapping("/{id}")
    public QuizAttempt getQuizAttemptById(@PathVariable Long id) {
        return quizAttemptService.getQuizAttemptById(id);
    }

    @PutMapping("/{id}")
    public QuizAttempt updateQuizAttempt(
            @PathVariable Long id,
            @RequestBody QuizAttempt attempt) {
        return quizAttemptService.updateQuizAttempt(id, attempt);
    }

    @DeleteMapping("/{id}")
    public void deleteQuizAttempt(@PathVariable Long id) {
        quizAttemptService.deleteQuizAttempt(id);
    }
}
