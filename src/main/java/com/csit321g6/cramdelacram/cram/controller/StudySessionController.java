package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.csit321g6.cramdelacram.cram.entity.StudySessionEntity;
import com.csit321g6.cramdelacram.cram.service.StudySessionService;

@RestController
@RequestMapping("/api/study-sessions")
public class StudySessionController {
    final StudySessionService sessionService;

    StudySessionController(StudySessionService sessionService) {
        this.sessionService = sessionService;
    }
    @PostMapping
    public StudySessionEntity createSession(@RequestBody StudySessionEntity session) {
        return sessionService.createSession(session);
    }

    @GetMapping
    public List<StudySessionEntity> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @PutMapping("/{id}")
    public StudySessionEntity updateSession(@PathVariable Long id, @RequestBody StudySessionEntity details) {
        return sessionService.updateSession(id, details);
    }

    @DeleteMapping("/{id}")
    public String deleteSession(@PathVariable Long id) {
        return sessionService.deleteSession(id);
    }
}