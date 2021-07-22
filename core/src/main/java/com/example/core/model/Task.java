package com.example.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Task {

    @JsonProperty(value = "id", required = true)
    private long id;
    @JsonProperty(value = "subject", required = true)
    private String subject;
    @JsonProperty(value = "description", required = true)
    private String description;
    @JsonProperty(value = "authorId", required = true)
    private long authorId;
    @JsonProperty(value = "executorId", required = true)
    private long executorId;
    @JsonProperty(value = "status", required = true)
    private TaskStatus status;
    @JsonProperty(value = "createdAt", required = true)
    private long createdAt;
}
