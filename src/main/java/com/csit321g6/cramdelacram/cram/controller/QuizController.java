package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.csit321g6.cramdelacram.cram.entity.QuizEntity;
import com.csit321g6.cramdelacram.cram.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public QuizEntity createQuiz(@RequestBody QuizEntity quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping
    public List<QuizEntity> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public QuizEntity getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    @PutMapping("/{id}")
    public QuizEntity updateQuiz(@PathVariable Long id, @RequestBody QuizEntity quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }
}
