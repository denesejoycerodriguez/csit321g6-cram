package com.csit321g6.cramdelacram.cram.controller;

import com.csit321g6.cramdelacram.cram.entity.ReviewMaterial;
import com.csit321g6.cramdelacram.cram.service.ReviewMaterialService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materials")
public class ReviewMaterialController {
    private final ReviewMaterialService service;

    public ReviewMaterialController(ReviewMaterialService service) { this.service = service; }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public ReviewMaterial create(@Valid @RequestBody ReviewMaterial m) { return service.create(m); }

    @GetMapping
    public List<ReviewMaterial> list(@RequestParam(required = false) Long topicId) { return service.getAll(topicId); }

    @GetMapping("/{id}")
    public ReviewMaterial get(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public ReviewMaterial update(@PathVariable Long id, @Valid @RequestBody ReviewMaterial m) { return service.update(id, m); }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}