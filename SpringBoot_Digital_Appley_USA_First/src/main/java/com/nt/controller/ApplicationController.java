package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.CustomerApplication;
import com.nt.sevice.ApplicationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @GetMapping("/getdata")
    public List<CustomerApplication> customerApplications() {
        return service.fetchAllData();
    }

    @PostMapping("/insert")
    public ResponseEntity<CustomerApplication> apply(@RequestBody @Valid CustomerApplication app) {
        return ResponseEntity.ok(service.apply(app));
    }

    @PutMapping("/process/{id}")
    public ResponseEntity<CustomerApplication> process(
            @PathVariable Long id,
            @RequestBody @Valid CustomerApplication updatedApp) {
        return ResponseEntity.ok(service.processApplication(id, updatedApp));
    }
}
