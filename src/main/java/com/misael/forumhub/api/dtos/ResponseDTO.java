package com.misael.forumhub.api.dtos;

import com.misael.forumhub.domain.models.Topic;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseDTO {

    private Long id;
    private String name;
    private Topic topic;
    private LocalDateTime creationDate;
    private String user;
}
