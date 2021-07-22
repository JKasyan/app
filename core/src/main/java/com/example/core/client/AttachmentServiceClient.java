package com.example.core.client;

import com.example.core.model.Attachment;

import java.util.Collection;

public interface AttachmentServiceClient {

    Collection<Attachment> getByTaskId(long taskId);
}
