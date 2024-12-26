package com.misael.forumhub.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseIdDTO {

    @NotNull
    @JsonProperty("id") // JSON usará "id" ao invés de "courseId"
    private Long courseId;
}
