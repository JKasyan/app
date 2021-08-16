package com.example.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @JsonProperty(value = "id", required = true)
    private long id;
    @JsonProperty(value = "name", required = true)
    private String name;
}
