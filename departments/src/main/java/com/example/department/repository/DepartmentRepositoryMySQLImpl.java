package com.example.department.repository;

import com.example.core.model.Department;

import java.util.Optional;

public class DepartmentRepositoryMySQLImpl implements DepartmentRepository {
    @Override
    public Optional<Department> getById(final long id) {
        return Optional.empty();
    }
}
