package com.spring.hw1.repositories;

import com.spring.hw1.domain.Task;
import com.spring.hw1.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findTasksByStatus(TaskStatus status);
}
