package com.csit321g6.cramdelacram.cram.service;

import org.springframework.stereotype.Service;
import com.csit321g6.cramdelacram.cram.entity.StudyReminderEntity;
import com.csit321g6.cramdelacram.cram.repository.StudyReminderRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudyReminderService {
    final StudyReminderRepository reminderRepo;

    StudyReminderService(StudyReminderRepository reminderRepo) {
        this.reminderRepo = reminderRepo;
    }

    public StudyReminderEntity createReminder(StudyReminderEntity reminder) {
        return reminderRepo.save(reminder);
    }

    public List<StudyReminderEntity> getAllReminders() {
        return reminderRepo.findAll();
    }

    public StudyReminderEntity updateReminder(Long id, StudyReminderEntity details) {
        StudyReminderEntity reminder = new StudyReminderEntity();
        try {
            reminder = reminderRepo.findById(id).get();
            reminder.setUser(details.getUser());
            reminder.setExam(details.getExam());
            reminder.setReminderTime(details.getReminderTime());
            reminder.setMessage(details.getMessage());
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Study Reminder " + id + " does not exist!");
        }
        return reminderRepo.save(reminder);
    }

    public String deleteReminder(Long id) {
        String msg = "";
        if (reminderRepo.findById(id).isPresent()) {
            reminderRepo.deleteById(id);
            msg = "Study Reminder is successfully deleted!";
        } else {
            msg = "Study Reminder does not exist!";
        }
        return msg;
    }
}