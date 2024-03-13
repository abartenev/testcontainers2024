package com.example.testcontainers2024.repositories;

import com.example.testcontainers2024.models.Address;
import com.example.testcontainers2024.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
}
