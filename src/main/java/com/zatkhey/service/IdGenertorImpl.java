package com.zatkhey.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGenertorImpl implements IdGenerator {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}