package com.csit321g6.cramdelacram.cram.service;

import com.csit321g6.cramdelacram.cram.entity.UserEntity;
import com.csit321g6.cramdelacram.cram.repository.UserRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class UserService {

    private final UserRepository users;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository users) {
        this.users = users;
    }

    public UserEntity create(UserEntity u) {
        if (u.getPassword() == null || u.getPassword().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password is required");
        if (users.existsByUsername(u.getUsername()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already taken");
        if (users.existsByEmail(u.getEmail()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        u.setId(null);
        u.setPassword(encoder.encode(u.getPassword()));
        if (u.getRole() == null) u.setRole(UserEntity.Role.STUDENT);
        return users.save(u);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAll() {
        return users.findAll();
    }

    @Transactional(readOnly = true)
    public UserEntity getById(Long id) {
        return users.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found"));
    }

    public UserEntity update(Long id, UserEntity in) {
        UserEntity u = getById(id);
        if (users.existsByUsernameAndIdNot(in.getUsername(), id))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already taken");
        if (users.existsByEmailAndIdNot(in.getEmail(), id))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        u.setUsername(in.getUsername());
        u.setEmail(in.getEmail());
        u.setFullName(in.getFullName());
        if (in.getRole() != null) u.setRole(in.getRole());
        if (in.getPassword() != null && !in.getPassword().isBlank())
            u.setPassword(encoder.encode(in.getPassword()));
        return users.save(u);
    }

    public void delete(Long id) {
        users.delete(getById(id));
    }
}