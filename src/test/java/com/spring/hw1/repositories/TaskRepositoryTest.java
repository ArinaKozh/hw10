package com.spring.hw1.repositories;

import com.spring.hw1.domain.Task;
import com.spring.hw1.domain.TaskStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.spring.hw1.domain.TaskStatus.IN_PROGRESS;
import static com.spring.hw1.domain.TaskStatus.NOT_STARTED;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void FindByCreationDate(){

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

        taskRepository.save(task2);
        taskRepository.save(task1);

        TaskStatus status = IN_PROGRESS;

        List<Task> result = taskRepository.findTasksByStatus(IN_PROGRESS);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(task2);
    }
}
