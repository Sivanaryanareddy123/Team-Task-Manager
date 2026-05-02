package com.task.Respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Model.Project;
public interface ProjectRepository extends JpaRepository<Project, Long> {}