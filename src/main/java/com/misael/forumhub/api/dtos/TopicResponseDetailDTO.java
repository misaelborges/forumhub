package com.misael.forumhub.api.dtos;

import com.misael.forumhub.domain.models.TopicStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopicResponseDetailDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private TopicStatus status;
    private String authorName;
}
