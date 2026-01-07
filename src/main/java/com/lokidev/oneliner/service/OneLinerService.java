package com.lokidev.oneliner.service;

import com.lokidev.oneliner.entity.OneLiner;
import com.lokidev.oneliner.repository.OneLinerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneLinerService {

    private final OneLinerRepository repository;

    public OneLinerService(OneLinerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OneLiner save(OneLiner oneLiner) {
        return repository.save(oneLiner);
    }

    public List<OneLiner> getByContext(String context) {
        return repository.findByContextIgnoreCase(context);
    }

    public List<OneLiner> getByAuthor(String author) {
        return repository.findByAuthorIgnoreCase(author);
    }
}

