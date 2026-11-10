package com.csit321g6.cramdelacram.cram.controller;

import com.csit321g6.cramdelacram.cram.entity.Flashcard;
import com.csit321g6.cramdelacram.cram.service.FlashcardService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flashcards")
public class FlashcardController {
    private final FlashcardService service;

    public FlashcardController(FlashcardService service) { this.service = service; }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Flashcard create(@Valid @RequestBody Flashcard f) { return service.create(f); }

    @GetMapping
    public List<Flashcard> list(@RequestParam(required = false) Long topicId) { return service.getAll(topicId); }

    @GetMapping("/{id}")
    public Flashcard get(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public Flashcard update(@PathVariable Long id, @Valid @RequestBody Flashcard f) { return service.update(id, f); }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}