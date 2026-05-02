package com.task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.task.Model.Project;
import com.task.Service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    public Project create(@RequestBody Project project) {
        return service.create(project);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAll();
    }
}
