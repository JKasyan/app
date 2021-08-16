package com.example.core.client.impl;

import com.example.core.client.AbstractClient;
import com.example.core.client.TaskServiceClient;
import com.example.core.consul.Service;
import com.example.core.model.Task;
import com.example.core.model.TaskStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class TaskServiceClientConsulImpl extends AbstractClient implements TaskServiceClient {

    private static final Logger log = LoggerFactory.getLogger(TaskServiceClientConsulImpl.class);

    public TaskServiceClientConsulImpl(final RestTemplate rt) {
        super(Service.TASK, rt);
    }

    public Collection<Task> getByDepId(final long depId) {
        String url = UriComponentsBuilder.fromUriString("/api/task")
                .queryParam("departmentId", depId)
                .host("http://" + service.name().toLowerCase())
                .toString();
        log.warn("url: {}", url);
        return Arrays.stream(
                super.call(
                        "http://task/api/task?departmentId=" + depId, // TODO: UriComponentsBuilder
                        Task[].class
                )
        ).collect(Collectors.toList());
    }

    public void updateStatus(final long id, final TaskStatus status) {
        //
    }

    public Task getBydId(final long id) {
        return super.call("http://task/api/task/" + id, Task.class);
    }

    public Task store(final Task entity) {
        return null;
    }
}
