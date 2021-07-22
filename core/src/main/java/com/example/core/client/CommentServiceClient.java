package com.example.core.client;

import com.example.core.model.Comment;

import java.util.Collection;

public interface CommentServiceClient extends Storable<Comment>, Deletable {

    Collection<Comment> getByTaskId(long taskId);

}
