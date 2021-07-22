package com.example.core.client.impl;

import com.example.core.client.TaskServiceClient;
import com.example.core.model.Task;
import com.example.core.model.TaskStatus;

import java.util.Collection;
import java.util.Collections;

public class TaskServiceClientMock implements TaskServiceClient {

    public Collection<Task> getByDepId(final long depId) {
        return Collections.emptyList();
    }

    public void updateStatus(final long id, final TaskStatus status) {

    }

    public Task getBydId(final long id) {
        return null;
    }

    public Task store(final Task entity) {
        return null;
    }
}
