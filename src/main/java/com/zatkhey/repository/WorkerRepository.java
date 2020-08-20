package com.zatkhey.repository;

import com.zatkhey.model.Worker;

import java.util.List;

public interface WorkerRepository {
    void save(Worker worker);

    Worker find(String id);
    List<Worker> findAll();

    Worker delete(String id);

}