package com.example.testcontainers2024.services;

import com.example.testcontainers2024.models.Company;
import com.example.testcontainers2024.repositories.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> companies(){
        return companyRepo.findAll();
    };
}
