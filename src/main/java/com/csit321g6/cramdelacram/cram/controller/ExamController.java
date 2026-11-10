package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.csit321g6.cramdelacram.cram.entity.ExamEntity;
import com.csit321g6.cramdelacram.cram.service.ExamService;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    final ExamService examService;

    ExamController(ExamService examService) {
        this.examService = examService;
    }
    @PostMapping
    public ExamEntity createExam(@RequestBody ExamEntity exam){
        return examService.createExam(exam);
    }

    @GetMapping
    public List<ExamEntity> getAllExams(){
        return examService.getAllExams();
    }

    @PutMapping("/{id}")
    public ExamEntity updateExam(@PathVariable Long id, @RequestBody ExamEntity examDetails){
        return examService.updateExam(id, examDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable Long id){
        return examService.deleteExam(id);
    }
}