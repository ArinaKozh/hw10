package com.spring.hw1.integration;

import com.spring.hw1.domain.Task;
import com.spring.hw1.repositories.TaskRepository;
import com.spring.hw1.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import static com.spring.hw1.domain.TaskStatus.IN_PROGRESS;
import static com.spring.hw1.domain.TaskStatus.NOT_STARTED;

@SpringBootTest
public class ServiceIntegrationTest {

    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @Test
    void findTaskByStatus(){
        Task task1 = new Task();
        task1.setId(1L);
        task1.setStatus(NOT_STARTED);
        task1.setDescription("task1");
        task1.setCreationDate(LocalDateTime.of(2022,12,13,20,55));


        Task task2 = new Task();
        task2.setId(2L);
        task2.setStatus(IN_PROGRESS);
        task2.setDescription("task2");
        task2.setCreationDate(LocalDateTime.of(2023,12,13,20,55));

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        given(taskRepository.findAll()).willReturn(tasks);

        taskService.findTasksByStatus(IN_PROGRESS);

        verify(taskRepository).findTasksByStatus(IN_PROGRESS);
    }




}
