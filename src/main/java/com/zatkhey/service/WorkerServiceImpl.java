package com.zatkhey.service;

import com.zatkhey.model.Worker;
import com.zatkhey.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private IdGenerator idGenerator;
    private WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(IdGenerator idGenerator, WorkerRepository workerRepository) {
        this.idGenerator = idGenerator;
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker createWorker(String firstName, String lastName) {
        String id = idGenerator.generateId();

        Worker worker = new Worker(id, firstName, lastName);

        workerRepository.save(worker);
        return worker;
    }

    @Override
    public Worker findWorkerByFirstNameAndLastName(String firstName, String lastName) {
        List<Worker> workers = workerRepository.findAll();
        return workers
                .stream()
                .filter(worker -> worker.getFirstName().equals(firstName)
                        && worker.getLastName().equals(lastName))
                .findFirst()
                .get();
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }
}
