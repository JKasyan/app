package com.example.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Department {

    @JsonProperty(value = "id", required = true)
    private long id;
    @JsonProperty(value = "id", required = true)
    private String name;
}
