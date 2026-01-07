package com.lokidev.oneliner.controller;

import com.lokidev.oneliner.entity.OneLiner;
import com.lokidev.oneliner.service.OneLinerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/one-liners")
public class OneLinerController {

    private final OneLinerService service;

    public OneLinerController(OneLinerService service) {
        this.service = service;
    }

    @PostMapping
    public OneLiner create(@RequestBody OneLiner oneLiner) {
        return service.save(oneLiner);
    }

    @GetMapping
    public List<OneLiner> search(
            @RequestParam(required = false) String context,
            @RequestParam(required = false) String author
    ) {
        if (context != null) return service.getByContext(context);
        if (author != null) return service.getByAuthor(author);
        throw new IllegalArgumentException("Provide context or author");
    }
}

