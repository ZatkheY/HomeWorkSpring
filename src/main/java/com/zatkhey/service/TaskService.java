package com.zatkhey.service;

import com.zatkhey.model.Task;
import com.zatkhey.model.Worker;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    Task createTask(String description, LocalDateTime from, LocalDateTime to, BigDecimal price);
    Task saveTask(Task task);
    List<Task> findAllTasks();
    List<Task> findTasksAssignedToWorker(Worker worker);

}
