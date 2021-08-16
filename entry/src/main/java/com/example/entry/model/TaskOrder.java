package com.example.entry.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum TaskOrder {

    CREATED_AT("createdAt");

    @Getter
    private final String fieldName;

    TaskOrder(final String fieldName) {
        this.fieldName = fieldName;
    }

    @JsonCreator
    public TaskOrder forValue(final String fieldName) {
        return TaskOrder.valueOf(fieldName.toUpperCase());
    }
}
