package com.example.testcontainers2024.repositories;

import com.example.testcontainers2024.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
}
