package com.example.department.facade;

import com.example.core.model.Department;
import com.example.department.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/api/department")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(final DepartmentRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/{id}")
    public Department getById(@PathVariable final long id) {
        return repository.getById(id).orElseThrow();
    }
}
