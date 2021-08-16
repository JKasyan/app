package com.example.entry.facade;

import com.example.core.client.AttachmentServiceClient;
import com.example.core.client.CommentServiceClient;
import com.example.core.client.DepartmentServiceClient;
import com.example.core.client.TaskServiceClient;
import com.example.core.client.UserServiceClient;
import com.example.core.model.Attachment;
import com.example.core.model.Comment;
import com.example.core.model.Department;
import com.example.core.model.Task;
import com.example.core.model.TaskStatus;
import com.example.core.model.User;
import com.example.entry.http.OuterService;
import com.example.entry.model.RatingAwareUser;
import com.example.entry.model.TaskDetails;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController()
@RequestMapping("api/")
public class EntryFacade {

    private final TaskServiceClient tsc;
    private final DepartmentServiceClient dsc;
    private final OuterService os;
    private final UserServiceClient usc;
    private final CommentServiceClient csc;
    private final AttachmentServiceClient asc;

    private static final int DEFAULT_USER_RATING = 0;

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public Collection<Task> getTasksBy(@RequestParam final long depId) {
        return tsc.getByDepId(depId);
    }

    @RequestMapping(value = "/department/{id}")
    public Department getDep(@PathVariable final long id) {
        return dsc.getBydId(id);
    }

    @RequestMapping(value = "/user/{id}")
    public User getUser(@PathVariable final long id) {
        Optional<Integer> rating = os.getRating(id);
        return Optional.ofNullable(usc.getBydId(id))
                .map(u -> new RatingAwareUser(u, rating.orElse(DEFAULT_USER_RATING)))
                .orElse(null);
    }

    @RequestMapping(value = "/taskDetails/{id}")
    public TaskDetails getTaskDetails(@PathVariable final long id) {
        return new TaskDetails(
                id,
                csc.getByTaskId(id).toArray(new Comment[0]),
                asc.getByTaskId(id).toArray(new Attachment[0])
        );
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Task createTask(@NonNull @RequestBody final Task task) {
        return tsc.store(task);
    }

    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.PUT)
    public void updateStatus(@PathVariable final long taskId, @RequestParam final TaskStatus status) {
        tsc.updateStatus(taskId, status);
    }

    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.POST)
    public Comment addComment(@PathVariable final long taskId, @NonNull final String content) {
        return csc.store(Comment.withoutId(content, taskId));
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable final long id) {
        csc.delete(id);
    }
}
