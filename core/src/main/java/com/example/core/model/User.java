package com.example.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class User {

    @JsonProperty(value = "id", required = true)
    private long id;
    @JsonProperty(value = "name", required = true)
    private String name;
    @JsonProperty(value = "depId", required = true)
    private long depId;

    public User(final long id, final String name, final long depId) {
        this.id = id;
        this.name = name;
        this.depId = depId;
    }
}
