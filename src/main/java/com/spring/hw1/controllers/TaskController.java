package com.spring.hw1.controllers;

import com.spring.hw1.domain.TaskStatus;
import com.spring.hw1.repositories.TaskRepository;
import com.spring.hw1.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.hw1.domain.Task;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PostMapping("/description")
    public Task createTask(@PathVariable String description) {
        return taskService.createTask(description);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.findTasksByStatus(status);
    }
    @PutMapping("/{id}/status/{status}")
    public Task updateTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status){
        return taskService.updateTaskStatus(id, status);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }


}
