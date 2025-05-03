package com.neiljeffries.apache_ignite_java.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neiljeffries.apache_ignite_java.ApacheIgniteJavaApplication;
// import com.neiljeffries.apache_ignite_java.services.GreetingService;

@RestController
@RequestMapping("/cache")
public class GreetingController {

    private final ApacheIgniteJavaApplication app;

    public GreetingController(ApacheIgniteJavaApplication app) {
        this.app = app;
    }

    @PostMapping("/{id}")
    public String put(@PathVariable Long id, @RequestBody String value) {
        app.putCache(id, value);
        return "Stored";
    }
    
    @GetMapping("/{id}")
    public String get(@PathVariable Long id) {
        return app.getCache(id);
    }
}
