package com.example.department.repository;

import com.example.core.model.Department;

import java.util.Optional;

public interface DepartmentRepository {

    Optional<Department> getById(long id);
}
