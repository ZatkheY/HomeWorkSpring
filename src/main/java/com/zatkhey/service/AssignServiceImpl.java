package com.zatkhey.service;

import com.zatkhey.model.Task;
import com.zatkhey.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignServiceImpl implements AssignService {

    private TaskService taskService;
@Autowired
    public AssignServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task assignTask(Worker worker, Task task) {
        task.setAssignee(worker);
        return taskService.saveTask(task);
    }
}