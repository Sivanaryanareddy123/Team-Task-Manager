package com.task.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Model.Task;
import com.task.Respository.TaskRepository;

import java.time.LocalDate;
import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task create(Task t) {
        return repo.save(t);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task update(Long id, Task updated) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(updated.getStatus());
        return repo.save(task);
    }

    public Map<String, Object> dashboard() {
        List<Task> tasks = repo.findAll();

        long completed = tasks.stream()
                .filter(t -> "Done".equalsIgnoreCase(t.getStatus()))
                .count();

        long overdue = tasks.stream()
                .filter(t -> t.getDueDate() != null &&
                        t.getDueDate().isBefore(LocalDate.now()) &&
                        !"Done".equalsIgnoreCase(t.getStatus()))
                .count();

        Map<String, Object> map = new HashMap<>();
        map.put("total", tasks.size());
        map.put("completed", completed);
        map.put("overdue", overdue);

        return map;
    }
}
