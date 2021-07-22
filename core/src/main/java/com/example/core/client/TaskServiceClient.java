package com.example.core.client;

import com.example.core.model.Task;
import com.example.core.model.TaskStatus;

import java.util.Collection;

public interface TaskServiceClient extends IdSearchable<Task>, Storable<Task> {

    Collection<Task> getByDepId(long depId);

    void updateStatus(long id, TaskStatus status);
}
