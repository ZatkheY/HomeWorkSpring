package com.zatkhey.service;

import java.util.UUID;

public class IdGenertorImpl implements IdGenerator {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}