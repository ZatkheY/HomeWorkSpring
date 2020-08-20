package com.zatkhey.service;

import com.zatkhey.model.Task;
import com.zatkhey.model.Worker;

public interface AssignService {
    Task assignTask(Worker worker, Task task);
}
