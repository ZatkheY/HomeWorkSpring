package com.zatkhey.service;

import com.zatkhey.model.Task;
import com.zatkhey.model.Worker;
import com.zatkhey.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService {
    private IdGenerator idGenerator;
    private TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(IdGenerator idGenerator, TaskRepository taskRepository) {
        this.idGenerator = idGenerator;
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String description, LocalDateTime from, LocalDateTime to, BigDecimal price) {
        String id = idGenerator.generateId();
        Task task = new Task(id, description, from, to, price);
        saveTask(task);
        return task;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findTasksAssignedToWorker(Worker worker) {
        List<Task> tasks = findAllTasks();
        return tasks
                .stream()
                .filter(task -> task.getAssignee().getId().equals(worker.getId()))
                .collect(Collectors.toList());
    }


}
