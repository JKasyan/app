package com.example.core.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private long id;
    private String content;
    private long taskId;

    public Comment(final String content, final long taskId) {
        this.content = content;
        this.taskId = taskId;
    }

    public static Comment withoutId(final String content, final long taskId) {
        return new Comment(content, taskId);
    }
}
