package com.csit321g6.cramdelacram.cram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csit321g6.cramdelacram.cram.entity.QuizEntity;
import com.csit321g6.cramdelacram.cram.repository.QuizRepository;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public QuizEntity createQuiz(QuizEntity quiz) {
        return quizRepository.save(quiz);
    }

    public List<QuizEntity> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public QuizEntity getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public QuizEntity updateQuiz(Long id, QuizEntity quizDetails) {
        QuizEntity quiz = getQuizById(id);

        if (quiz == null) {
            return null;
        }

        quiz.setTitle(quizDetails.getTitle());
        quiz.setTimeLimit(quizDetails.getTimeLimit());
        quiz.setTopic(quizDetails.getTopic());

        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
