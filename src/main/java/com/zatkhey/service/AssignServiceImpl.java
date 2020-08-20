package com.zatkhey.service;

import com.zatkhey.model.Task;
import com.zatkhey.model.Worker;

public class AssignServiceImpl implements AssignService {

    private TaskService taskService;

    public AssignServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task assignTask(Worker worker, Task task) {
        task.setAssignee(worker);
        return taskService.saveTask(task);
    }
}