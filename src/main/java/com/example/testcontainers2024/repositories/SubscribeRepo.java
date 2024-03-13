package com.example.testcontainers2024.repositories;

import com.example.testcontainers2024.models.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribeRepo extends JpaRepository<Subscribe, Integer> {
List<Subscribe> findByName(String name);
}
