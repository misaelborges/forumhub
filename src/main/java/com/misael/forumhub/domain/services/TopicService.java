package com.misael.forumhub.domain.services;

import com.misael.forumhub.domain.exceptions.DuplicateTopicException;
import com.misael.forumhub.domain.exceptions.NotFoundTopicException;
import com.misael.forumhub.domain.models.Topic;
import com.misael.forumhub.domain.repositories.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicService {

    @Autowired
    private ITopicRepository topicRepository;

    @Transactional
    public Topic save(Topic topic) {
        validateDuplicateTopic(topic);

        return topicRepository.save(topic);
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new NotFoundTopicException(id));
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        topicRepository.deleteById(id);
    }

    private void validateDuplicateTopic(Topic topic) {
        topicRepository.findByTitleIgnoreCaseAndMessageIgnoreCase(topic.getTitle(), topic.getMessage())
                .ifPresent(existingTopic -> {

                    // Verifica se o tópico encontrado não é o mesmo que está sendo atualizado
                    if (!existingTopic.getId().equals(topic.getId())) {
                        throw new DuplicateTopicException();
                    }
                });
    }
}
