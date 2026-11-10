package com.csit321g6.cramdelacram.cram.service;

import com.csit321g6.cramdelacram.cram.entity.ReviewMaterial;
import com.csit321g6.cramdelacram.cram.entity.TopicEntity;
import com.csit321g6.cramdelacram.cram.repository.ReviewMaterialRepository;
import com.csit321g6.cramdelacram.cram.repository.TopicRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class ReviewMaterialService {

    private final ReviewMaterialRepository materials;
    private final TopicRepository topics;

    public ReviewMaterialService(ReviewMaterialRepository materials, TopicRepository topics) {
        this.materials = materials;
        this.topics = topics;
    }

    public ReviewMaterial create(ReviewMaterial m) {
        m.setId(null);
        m.setTopic(findTopic(m.getTopic()));
        return materials.save(m);
    }

    @Transactional(readOnly = true)
    public List<ReviewMaterial> getAll(Long topicId) {
        return topicId == null ? materials.findAll() : materials.findByTopicId(topicId);
    }

    @Transactional(readOnly = true)
    public ReviewMaterial getById(Long id) {
        return materials.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "ReviewMaterial " + id + " not found"));
    }

    public ReviewMaterial update(Long id, ReviewMaterial in) {
        ReviewMaterial m = getById(id);
        m.setTitle(in.getTitle());
        m.setType(in.getType());
        m.setContent(in.getContent());
        m.setResourceUrl(in.getResourceUrl());
        if (in.getTopic() != null && in.getTopic().getId() != null)
            m.setTopic(findTopic(in.getTopic()));
        return materials.save(m);
    }

    public void delete(Long id) {
        materials.delete(getById(id));
    }

    private TopicEntity findTopic(TopicEntity ref) {
        if (ref == null || ref.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "topic.id is required");
        return topics.findById(ref.getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic " + ref.getId() + " not found"));
    }
}