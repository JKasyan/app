package com.example.core.client.impl;

import com.example.core.client.AbstractClient;
import com.example.core.client.DepartmentServiceClient;
import com.example.core.consul.Service;
import com.example.core.model.Department;
import org.springframework.web.client.RestTemplate;

public class DepartmentServiceClientConsulImpl extends AbstractClient implements DepartmentServiceClient {

    public DepartmentServiceClientConsulImpl(final RestTemplate restTemplate) {
        super(restTemplate, Service.DEPARTMENT);
    }

    @Override
    public Department getBydId(final long id) {
        return super.call(
                "/department/" + id,
                Department.class
        );
    }
}
