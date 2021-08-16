package com.example.entry.config;

import com.example.core.client.AttachmentServiceClient;
import com.example.core.client.CommentServiceClient;
import com.example.core.client.DepartmentServiceClient;
import com.example.core.client.TaskServiceClient;
import com.example.core.client.UserServiceClient;
import com.example.core.client.impl.DepartmentServiceClientConsulImpl;
import com.example.core.client.impl.TaskServiceClientConsulImpl;
import com.example.core.model.Comment;
import com.example.core.model.User;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Configuration
public class ClientsConfig {

    @Bean
    public TaskServiceClient taskServiceClient() {
        return new TaskServiceClientConsulImpl(restTemplate());
    }

    @Bean
    public DepartmentServiceClient departmentServiceClient() {
        return new DepartmentServiceClientConsulImpl(restTemplate());
    }

    @Bean
    public UserServiceClient userServiceClient() {
        return id -> new User(1L, "name", 1L);
    }

    @Bean
    public CommentServiceClient commentServiceClient() {
        return new CommentServiceClient() {
            @Override
            public Collection<Comment> getByTaskId(final long taskId) {
                return null;
            }

            @Override
            public boolean delete(final long id) {
                return false;
            }

            @Override
            public Comment store(final Comment entity) {
                return null;
            }
        };
    }

    @Bean
    public AttachmentServiceClient attachmentServiceClient() {
        return taskId -> null;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
