package com.misael.forumhub.api.assemblers;

import com.misael.forumhub.api.dtos.TopicRequestDTO;
import com.misael.forumhub.domain.models.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Topic toDomainObject(TopicRequestDTO topicRequest) {
        return modelMapper.map(topicRequest, Topic.class);
    }

    public void copyToDomainObject(TopicRequestDTO topicRequest, Topic topic) {
        modelMapper.map(topicRequest, topic);
    }
}
