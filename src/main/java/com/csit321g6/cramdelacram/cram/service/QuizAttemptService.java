package com.csit321g6.cramdelacram.cram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csit321g6.cramdelacram.cram.entity.QuizAttempt;
import com.csit321g6.cramdelacram.cram.repository.QuizAttemptRepository;

@Service
public class QuizAttemptService {

    private final QuizAttemptRepository quizAttemptRepository;

    public QuizAttemptService(QuizAttemptRepository quizAttemptRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
    }

    public QuizAttempt createQuizAttempt(QuizAttempt attempt) {
        return quizAttemptRepository.save(attempt);
    }

    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptRepository.findAll();
    }

    public QuizAttempt getQuizAttemptById(Long id) {
        return quizAttemptRepository.findById(id).orElse(null);
    }

    public QuizAttempt updateQuizAttempt(Long id, QuizAttempt attemptDetails) {
        QuizAttempt attempt = getQuizAttemptById(id);

        if (attempt == null) {
            return null;
        }

        attempt.setUser(attemptDetails.getUser());
        attempt.setQuiz(attemptDetails.getQuiz());
        attempt.setScore(attemptDetails.getScore());
        attempt.setAttemptedAt(attemptDetails.getAttemptedAt());

        return quizAttemptRepository.save(attempt);
    }

    public void deleteQuizAttempt(Long id) {
        quizAttemptRepository.deleteById(id);
    }
}
