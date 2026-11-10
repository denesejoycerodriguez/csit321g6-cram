package com.csit321g6.cramdelacram.cram.controller;

import com.csit321g6.cramdelacram.cram.entity.UserEntity;
import com.csit321g6.cramdelacram.cram.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@Valid @RequestBody UserEntity u) { return service.create(u); }

    @GetMapping
    public List<UserEntity> list() { return service.getAll(); }

    @GetMapping("/{id}")
    public UserEntity get(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public UserEntity update(@PathVariable Long id, @Valid @RequestBody UserEntity u) { return service.update(id, u); }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}