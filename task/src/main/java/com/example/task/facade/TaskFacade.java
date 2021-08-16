package com.example.task.facade;

import com.example.core.model.Department;
import com.example.core.model.Task;
import com.example.core.model.TaskStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@RequestMapping("/api")
@RestController
public class TaskFacade {

    private static final Logger log = LoggerFactory.getLogger(TaskFacade.class);

    @RequestMapping(value = "/task")
    public Collection<Task> getTasksByDepId(@RequestParam(value = "departmentId") final long depId) {
        log.warn("Get tasks by dep id {}", depId);
        return List.of(
                new Task(
                        depId,
                        "subject_" + depId,
                        "description_" + depId,
                        depId + 1,
                        depId + 2,
                        TaskStatus.NEW,
                        Instant.now().getEpochSecond()
                )
        );
    }

    @RequestMapping(value = "/task/{id}")
    public Task getById(@PathVariable final long id) {
        log.warn("Get task by id {}", id);
        return new Task(
                id,
                "subject_" + id,
                "description_" + id,
                id + 1,
                id + 2,
                TaskStatus.NEW,
                Instant.now().getEpochSecond()
        );
    }

    @RequestMapping(value = "/department/{depId}", method = RequestMethod.GET)
    public Department getDepById(@PathVariable final long depId) {
        return new Department(depId, "name_" + depId);
    }

}
