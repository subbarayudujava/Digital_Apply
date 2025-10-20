package com.nt.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CustomerApplication;
import com.nt.repository.CustomerApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private CustomerApplicationRepository repo;

    @Override
    public CustomerApplication apply(CustomerApplication app) {
        app.setStatus("PENDING");
        return repo.save(app);
    }

    @Override
    public CustomerApplication processApplication(Long id, CustomerApplication updatedApp) {
        CustomerApplication app = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));

        // Update fields from updatedApp if needed
        app.setIncome(updatedApp.getIncome());
        app.setName(updatedApp.getName());
        app.setEmail(updatedApp.getEmail());

        // Dummy eligibility check
        if (app.getIncome() > 30000) {
            app.setStatus("APPROVED");
        } else {
            app.setStatus("REJECTED");
        }

        return repo.save(app);
    }

    @Override
    public List<CustomerApplication> fetchAllData() {
        return repo.findAll();
    }
}
