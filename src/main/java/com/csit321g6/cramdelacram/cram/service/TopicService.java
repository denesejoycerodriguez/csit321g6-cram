package com.csit321g6.cramdelacram.cram.service;

import com.csit321g6.cramdelacram.cram.entity.Course;
import com.csit321g6.cramdelacram.cram.entity.Topic;
import com.csit321g6.cramdelacram.cram.repository.CourseRepository;
import com.csit321g6.cramdelacram.cram.repository.TopicRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class TopicService {

    private final TopicRepository topics;
    private final CourseRepository courses;

    public TopicService(TopicRepository topics, CourseRepository courses) {
        this.topics = topics;
        this.courses = courses;
    }

    public Topic create(Topic t) {
        t.setId(null);
        t.setCourse(findCourse(t.getCourse()));
        return topics.save(t);
    }

    @Transactional(readOnly = true)
    public List<Topic> getAll(Long courseId) {
        return courseId == null ? topics.findAll() : topics.findByCourseId(courseId);
    }

    @Transactional(readOnly = true)
    public Topic getById(Long id) {
        return topics.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic " + id + " not found"));
    }

    public Topic update(Long id, Topic in) {
        Topic t = getById(id);
        t.setTitle(in.getTitle());
        t.setDescription(in.getDescription());
        if (in.getCourse() != null && in.getCourse().getId() != null)
            t.setCourse(findCourse(in.getCourse()));
        return topics.save(t);
    }

    public void delete(Long id) {
        topics.delete(getById(id));
    }

    private Course findCourse(Course ref) {
        if (ref == null || ref.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "course.id is required");
        return courses.findById(ref.getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + ref.getId() + " not found"));
    }
}