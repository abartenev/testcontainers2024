package com.example.testcontainers2024.repositories;

import com.example.testcontainers2024.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber,Integer> {

List<Subscriber> findByFio(String fio);
}
