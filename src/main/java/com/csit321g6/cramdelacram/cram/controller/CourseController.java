package com.csit321g6.cramdelacram.cram.controller;

import com.csit321g6.cramdelacram.cram.entity.Course;
import com.csit321g6.cramdelacram.cram.service.CourseService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) { this.service = service; }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Course create(@Valid @RequestBody Course c) { return service.create(c); }

    @GetMapping
    public List<Course> list(@RequestParam(required = false) Long userId) { return service.getAll(userId); }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @Valid @RequestBody Course c) { return service.update(id, c); }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}