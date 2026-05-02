package com.task.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Model.Project;
import com.task.Respository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repo;

    public Project create(Project p) {
        return repo.save(p);
    }

    public List<Project> getAll() {
        return repo.findAll();
    }
}
