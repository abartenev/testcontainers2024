package com.example.testcontainers2024.services;

import com.example.testcontainers2024.dto.subscribing.subscriberStatus;
import com.example.testcontainers2024.models.Address;
import com.example.testcontainers2024.models.Subscriber;
import com.example.testcontainers2024.repositories.AddressRepo;
import com.example.testcontainers2024.repositories.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepo subscriberRepo;
    @Autowired
    private AddressRepo addressRepo;
    public subscriberStatus createSubscriber(Subscriber subscriber) {
        Address address = addressRepo.save(subscriber.getAddr_id());
        subscriber.setAddr_id(address);
        List<Subscriber> subscribers = subscriberRepo.findByFio(subscriber.getFio());
        if (subscribers.size() > 0) {
            return new subscriberStatus(false, String.format("Пользователь %s уже существует", subscribers.get(0).getFio()));
        }
        subscriber = subscriberRepo.save(subscriber);
        return new subscriberStatus(true, String.format("Пользователь %s сохранен в базу", subscriber.getFio()));
    }
}
