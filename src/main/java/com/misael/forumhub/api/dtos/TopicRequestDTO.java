package com.misael.forumhub.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String message;

    @NotNull
    @Valid
    private CourseIdDTO courseId;
}
