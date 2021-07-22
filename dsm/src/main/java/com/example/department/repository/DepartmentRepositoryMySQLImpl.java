package com.example.department.repository;

import com.example.core.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DepartmentRepositoryMySQLImpl implements DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentRepositoryMySQLImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Department> getById(final long id) {
        return jdbcTemplate.query(
                "SELECT * FROM Department WHERE id=?",
                (entity, rowNumber) -> new Department(entity.getLong("id"), entity.getString("name")),
                id
        ).stream().findAny();
    }
}
