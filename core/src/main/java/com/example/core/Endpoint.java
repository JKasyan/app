package com.example.core;

import com.example.core.consul.Service;
import lombok.Getter;
import lombok.NonNull;

public enum Endpoint {

    DEP_GET(Service.TASK, "/api/task?departmentId=%d"),
    TASK_GET(Service.TASK, "/api/task/%d");

    @Getter
    private final Service service;
    @Getter
    private final String path;

    Endpoint(@NonNull final Service service, @NonNull final String urlTemplate) {
        this.service = service;
        this.path = urlTemplate;
    }

    public String createUrl() {
        return "http://" + service.name().toLowerCase();
    }
}
