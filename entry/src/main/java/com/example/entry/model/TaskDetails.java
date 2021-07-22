package com.example.entry.model;

import com.example.core.model.Attachment;
import com.example.core.model.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDetails {

    @JsonProperty
    private long taskId;
    @JsonProperty
    private Comment[] comments;
    @JsonProperty
    private Attachment[] attachments;

    public TaskDetails(final long taskId, final Comment[] comments, final Attachment[] attachments) {
        this.taskId = taskId;
        this.comments = comments;
        this.attachments = attachments;
    }
}
