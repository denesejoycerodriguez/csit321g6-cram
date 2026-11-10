package com.csit321g6.cramdelacram.cram.controller;

import com.csit321g6.cramdelacram.cram.entity.FlashcardEntity;
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
    public FlashcardEntity create(@Valid @RequestBody FlashcardEntity f) { return service.create(f); }

    @GetMapping
    public List<FlashcardEntity> list(@RequestParam(required = false) Long topicId) { return service.getAll(topicId); }

    @GetMapping("/{id}")
    public FlashcardEntity get(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public FlashcardEntity update(@PathVariable Long id, @Valid @RequestBody FlashcardEntity f) { return service.update(id, f); }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}