package com.task.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Model.Task;



public interface TaskRepository extends JpaRepository<Task, Long> {}