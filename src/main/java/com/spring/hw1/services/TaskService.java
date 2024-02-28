package com.spring.hw1.services;

import com.spring.hw1.domain.Task;
import com.spring.hw1.domain.TaskStatus;
import com.spring.hw1.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    /**
     * Получить все книги.
     * @return список книг.
     */
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

    public Task saveTask(Task task) {
        task.setCreationDate(LocalDateTime.now());
        return repository.save(task);
    }

    public Task createTask(String description) {
        Task newTask = new Task();
        newTask.setDescription(description);
        newTask.setStatus(TaskStatus.NOT_STARTED);
        newTask.setCreationDate(LocalDateTime.now());
        return saveTask(newTask);
    }

    public List<Task> findTasksByStatus(TaskStatus status){
        return repository.findTasksByStatus(status);
    }

    public Task updateTaskStatus(Long id, TaskStatus newStatus){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(newStatus);
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
