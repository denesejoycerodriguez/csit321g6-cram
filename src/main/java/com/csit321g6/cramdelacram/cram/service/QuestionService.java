package com.csit321g6.cramdelacram.cram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csit321g6.cramdelacram.cram.entity.QuestionEntity;
import com.csit321g6.cramdelacram.cram.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionEntity createQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    public List<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }

    public QuestionEntity getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public QuestionEntity updateQuestion(Long id, QuestionEntity questionDetails) {
        QuestionEntity question = getQuestionById(id);

        if (question == null) {
            return null;
        }

        question.setQuestionText(questionDetails.getQuestionText());
        question.setCorrectAnswer(questionDetails.getCorrectAnswer());
        question.setQuiz(questionDetails.getQuiz());

        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
