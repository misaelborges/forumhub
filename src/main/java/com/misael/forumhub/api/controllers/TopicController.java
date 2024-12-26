package com.misael.forumhub.api.controllers;

import com.misael.forumhub.api.assemblers.TopicAssembler;
import com.misael.forumhub.api.assemblers.TopicAssemblerDetail;
import com.misael.forumhub.api.assemblers.TopicDisassembler;
import com.misael.forumhub.api.dtos.TopicRequestDTO;
import com.misael.forumhub.api.dtos.TopicResponseDTO;
import com.misael.forumhub.api.dtos.TopicResponseDetailDTO;
import com.misael.forumhub.domain.models.Topic;
import com.misael.forumhub.domain.repositories.ITopicRepository;
import com.misael.forumhub.domain.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private TopicDisassembler topicDisassembler;

    @Autowired
    private TopicService topicService;

    @GetMapping
    public Page<TopicResponseDTO> findAll(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
        return topicAssembler.toCollectionModel(topicRepository.findTop10ByOrderByCreationDateAsc(pageable));
    }

    @GetMapping("/{id}")
    public TopicResponseDetailDTO findById(@PathVariable Long id) {
        return topicAssemblerDetail.toModel(topicService.findById(id));
    }

    @GetMapping("/search")
    List<TopicResponseDetailDTO>findByCourseNameAndYear(@RequestParam String nameCourse, @RequestParam Integer year) {
        return topicAssemblerDetail.toCollectionModel(topicRepository.findByCourseNameAndYear(nameCourse, year));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicResponseDTO save(@RequestBody @Valid TopicRequestDTO topicRequest) {
        Topic topic = topicDisassembler.toDomainObject(topicRequest);

        var topicSaved = topicService.save(topic);
        return topicAssembler.toModel(topicSaved);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TopicResponseDTO update(@PathVariable Long id, @RequestBody @Valid TopicRequestDTO topicRequest) {
        Topic topic = topicService.findById(id);
        topicDisassembler.copyToDomainObject(topicRequest, topic);
        topicService.save(topic);
        return topicAssembler.toModel(topic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }
}
