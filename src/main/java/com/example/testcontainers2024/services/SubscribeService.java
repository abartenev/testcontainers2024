package com.example.testcontainers2024.services;

import com.example.testcontainers2024.models.Subscribe;
import com.example.testcontainers2024.repositories.SubscribeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubscribeService {
    @Autowired
    private SubscribeRepo subscribeRepo;
    public void addSubscription(List<Subscribe> subscribe) {
        subscribeRepo.saveAll(subscribe);
    }

    public void delSubcription(String nameSubsribtion) {
        List<Subscribe> subscribes = subscribeRepo.findByName(nameSubsribtion);
        if (subscribes.size() > 0) {
            subscribeRepo.deleteAll(subscribes);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void updateSubcription(String nameSubsribtion, String newname) {
        List<Subscribe> subscribes = subscribeRepo.findByName(nameSubsribtion);
        if (subscribes.size() > 0) {
            subscribes.forEach(subscribe -> {
                subscribe.setName(newname);
                subscribeRepo.save(subscribe);
            });
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Subscribe> subscribes() {
        return subscribeRepo.findAll();
    }
}
