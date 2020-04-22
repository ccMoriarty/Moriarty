package com.example.demo.service;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;

import java.util.List;

public class DbService implements HttpTraceRepository {

    @Override
    public List<HttpTrace> findAll() {
        return null;
    }

    @Override
    public void add(HttpTrace trace) {

    }
}
