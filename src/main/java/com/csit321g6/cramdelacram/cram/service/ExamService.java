package com.csit321g6.cramdelacram.cram.service;

import org.springframework.stereotype.Service;
import com.csit321g6.cramdelacram.cram.entity.ExamEntity;
import com.csit321g6.cramdelacram.cram.repository.ExamRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service 
public class ExamService {
    final ExamRepository examRepo;

    ExamService(ExamRepository examRepo) {
        this.examRepo = examRepo;
    }

    public ExamEntity createExam(ExamEntity exam){
        return examRepo.save(exam);
    }

    public List<ExamEntity> getAllExams(){
        return examRepo.findAll();
    }

    public ExamEntity updateExam(Long id, ExamEntity examDetails){
        ExamEntity existingExam = new ExamEntity();
        try{
            existingExam = examRepo.findById(id).get();
            existingExam.setUserId(examDetails.getUserId());
            existingExam.setCourseId(examDetails.getCourseId());
            existingExam.setExamTitle(examDetails.getExamTitle());
            existingExam.setExamDate(examDetails.getExamDate());
        } catch(NoSuchElementException e){
            throw new RuntimeException("Exam " + id + " does not exist!");
        }
        return examRepo.save(existingExam);
    }

    public String deleteExam(Long id){
        String msg = "";
        if(examRepo.findById(id).isPresent()){
            examRepo.deleteById(id);
            msg = "Exam is successfully deleted!";
        } else {
            msg = "Exam does not exist!";
        }
        return msg;
    }
}