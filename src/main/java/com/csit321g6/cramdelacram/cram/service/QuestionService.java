package com.csit321g6.cramdelacram.cram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csit321g6.cramdelacram.cram.entity.Question;
import com.csit321g6.cramdelacram.cram.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question updateQuestion(Long id, Question questionDetails) {
        Question question = getQuestionById(id);

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
