package com.example.entry.config;

import com.example.core.client.DepartmentServiceClient;
import com.example.core.client.TaskServiceClient;
import com.example.core.client.impl.DepartmentServiceClientConsulImpl;
import com.example.core.client.impl.TaskServiceClientMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientsConfig {

    @Bean
    public TaskServiceClient taskServiceClient() {
        return new TaskServiceClientMock();
    }

    @Bean
    public DepartmentServiceClient departmentServiceClient() {
        return new DepartmentServiceClientConsulImpl(restTemplate());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
