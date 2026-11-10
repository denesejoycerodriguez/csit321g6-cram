package com.csit321g6.cramdelacram.cram.controller;

import com.csit321g6.cramdelacram.cram.entity.Topic;
import com.csit321g6.cramdelacram.cram.service.TopicService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicService service;

    public TopicController(TopicService service) { this.service = service; }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Topic create(@Valid @RequestBody Topic t) { return service.create(t); }

    @GetMapping
    public List<Topic> list(@RequestParam(required = false) Long courseId) { return service.getAll(courseId); }

    @GetMapping("/{id}")
    public Topic get(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public Topic update(@PathVariable Long id, @Valid @RequestBody Topic t) { return service.update(id, t); }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}