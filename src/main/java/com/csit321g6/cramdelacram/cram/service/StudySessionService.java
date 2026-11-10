package com.csit321g6.cramdelacram.cram.service;

import org.springframework.stereotype.Service;
import com.csit321g6.cramdelacram.cram.entity.StudySessionEntity;
import com.csit321g6.cramdelacram.cram.repository.StudySessionRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudySessionService {
    final StudySessionRepository sessionRepo;

    StudySessionService(StudySessionRepository sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    public StudySessionEntity createSession(StudySessionEntity session) {
        return sessionRepo.save(session);
    }

    public List<StudySessionEntity> getAllSessions() {
        return sessionRepo.findAll();
    }

    public StudySessionEntity updateSession(Long id, StudySessionEntity details) {
        StudySessionEntity session = new StudySessionEntity();
        try {
            session = sessionRepo.findById(id).get();
            session.setUser(details.getUser());
            session.setExam(details.getExam());
            session.setSessionDate(details.getSessionDate());
            session.setDurationMinutes(details.getDurationMinutes());
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Study Session " + id + " does not exist!");
        }
        return sessionRepo.save(session);
    }

    public String deleteSession(Long id) {
        String msg = "";
        if (sessionRepo.findById(id).isPresent()) {
            sessionRepo.deleteById(id);
            msg = "Study Session is successfully deleted!";
        } else {
            msg = "Study Session does not exist!";
        }
        return msg;
    }
}