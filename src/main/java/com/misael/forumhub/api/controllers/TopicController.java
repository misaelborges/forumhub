package com.misael.forumhub.api.controllers;

import com.misael.forumhub.api.assemblers.TopicAssembler;
import com.misael.forumhub.api.assemblers.TopicAssemblerDetail;
import com.misael.forumhub.api.dtos.TopicResponseDTO;
import com.misael.forumhub.api.dtos.TopicResponseDetailDTO;
import com.misael.forumhub.domain.exceptions.NotFoundTopicException;
import com.misael.forumhub.domain.repositories.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private ITopicRepository topicRepository;

    @Autowired
    private TopicAssembler topicAssembler;

    @Autowired
    private TopicAssemblerDetail topicAssemblerDetail;

    @GetMapping
    public Page<TopicResponseDTO> findAll(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
        return topicAssembler.toCollectionModel(topicRepository.findTop10ByOrderByCreationDateAsc(pageable));
    }

    @GetMapping("/{id}")
    public TopicResponseDetailDTO findById(@PathVariable Long id) {
        return topicAssemblerDetail.toModel(topicRepository.findById(id).orElseThrow(() -> new NotFoundTopicException(id)));
    }

    @GetMapping("/search")
    List<TopicResponseDetailDTO>findByCourseNameAndYear(@RequestParam String nameCourse, @RequestParam Integer year) {
        return topicAssemblerDetail.toCollectionModel(topicRepository.findByCourseNameAndYear(nameCourse, year));
    }
}
