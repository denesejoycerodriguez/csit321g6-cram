package com.csit321g6.cramdelacram.cram.service;

import com.csit321g6.cramdelacram.cram.entity.CourseEntity;
import com.csit321g6.cramdelacram.cram.entity.UserEntity;
import com.csit321g6.cramdelacram.cram.repository.CourseRepository;
import com.csit321g6.cramdelacram.cram.repository.UserRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class CourseService {

    private final CourseRepository courses;
    private final UserRepository users;

    public CourseService(CourseRepository courses, UserRepository users) {
        this.courses = courses;
        this.users = users;
    }

    public CourseEntity create(CourseEntity c) {
        c.setId(null);
        c.setUser(findUser(c.getUser()));
        return courses.save(c);
    }

    @Transactional(readOnly = true)
    public List<CourseEntity> getAll(Long userId) {
        return userId == null ? courses.findAll() : courses.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public CourseEntity getById(Long id) {
        return courses.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + id + " not found"));
    }

    public CourseEntity update(Long id, CourseEntity in) {
        CourseEntity c = getById(id);
        c.setCourseCode(in.getCourseCode());
        c.setTitle(in.getTitle());
        c.setDescription(in.getDescription());
        if (in.getUser() != null && in.getUser().getId() != null)
            c.setUser(findUser(in.getUser()));
        return courses.save(c);
    }

    public void delete(Long id) {
        courses.delete(getById(id));
    }

    private UserEntity findUser(UserEntity ref) {
        if (ref == null || ref.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user.id is required");
        return users.findById(ref.getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + ref.getId() + " not found"));
    }
}