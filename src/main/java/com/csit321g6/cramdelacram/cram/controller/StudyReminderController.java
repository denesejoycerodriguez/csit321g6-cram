package com.csit321g6.cramdelacram.cram.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.csit321g6.cramdelacram.cram.entity.StudyReminderEntity;
import com.csit321g6.cramdelacram.cram.service.StudyReminderService;

@RestController
@RequestMapping("/api/study-reminders")
public class StudyReminderController {
    final StudyReminderService reminderService;

    StudyReminderController(StudyReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping
    public StudyReminderEntity createReminder(@RequestBody StudyReminderEntity reminder) {
        return reminderService.createReminder(reminder);
    }

    @GetMapping
    public List<StudyReminderEntity> getAllReminders() {
        return reminderService.getAllReminders();
    }

    @PutMapping("/{id}")
    public StudyReminderEntity updateReminder(@PathVariable Long id, @RequestBody StudyReminderEntity details) {
        return reminderService.updateReminder(id, details);
    }

    @DeleteMapping("/{id}")
    public String deleteReminder(@PathVariable Long id) {
        return reminderService.deleteReminder(id);
    }
}