package com.example.department.facade;

import com.example.core.model.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/department")
public class DepartmentController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Department getById(@PathVariable final long id) {
        return new Department(1L, "dep");
    }
}
