package com.misael.forumhub.api.assemblers;

import com.misael.forumhub.api.dtos.TopicResponseDetailDTO;
import com.misael.forumhub.domain.models.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicAssemblerDetail {

    @Autowired
    private ModelMapper modelMapper;

    public TopicResponseDetailDTO toModel(Topic topic) {
        return modelMapper.map(topic, TopicResponseDetailDTO.class);
    }

    public List<TopicResponseDetailDTO> toCollectionModel(List<Topic> topics) {
        return topics.stream().map(this::toModel).toList();
    }
}
