package com.misael.forumhub.api.assemblers;

import com.misael.forumhub.api.dtos.TopicResponseDTO;
import com.misael.forumhub.domain.models.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component

public class TopicAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public TopicResponseDTO toModel(Topic topic) {
        return modelMapper.map(topic, TopicResponseDTO.class);
    }

    public Page<TopicResponseDTO> toCollectionModel(Page<Topic> topics) {
        return topics.map(this::toModel);
    }
}
