package com.misael.forumhub.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopicResponseDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
}
