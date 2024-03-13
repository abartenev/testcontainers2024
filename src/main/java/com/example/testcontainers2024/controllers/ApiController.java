package com.example.testcontainers2024.controllers;

import com.example.testcontainers2024.dto.subscribing.subscriberStatus;
import com.example.testcontainers2024.models.Company;
import com.example.testcontainers2024.models.Subscribe;
import com.example.testcontainers2024.models.Subscriber;
import com.example.testcontainers2024.services.CompanyService;
import com.example.testcontainers2024.services.SubscribeService;
import com.example.testcontainers2024.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    public SubscriberService subscriberService;
    public SubscribeService subscribeService;
    public CompanyService companyService;

    @Autowired
    public ApiController(SubscriberService subscriberService, SubscribeService subscribeService, CompanyService companyService) {
        this.subscriberService = subscriberService;
        this.subscribeService = subscribeService;
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String index() {

        return "Hello world from users service!";

    }

    @PostMapping("/users")
    public ResponseEntity<subscriberStatus> addSubscriber(@RequestBody Subscriber subscriber) {
        return ResponseEntity.ok(subscriberService.createSubscriber(subscriber));
    }

    @PostMapping("/subscribes")
    public void addSubscription(@RequestBody List<Subscribe> subscribes) {
        subscribeService.addSubscription(subscribes);
    }

    @DeleteMapping("/subscribes/{nameSubsribtion}")
    public void delSubscription(@PathVariable String nameSubsribtion) {
        subscribeService.delSubcription(nameSubsribtion);
    }

    @PutMapping("/subscribes/{nameSubsribtion}/{newname}")
    public void updateSubscription(@PathVariable String nameSubsribtion, @PathVariable String newname) {
        subscribeService.updateSubcription(nameSubsribtion, newname);
    }

    @GetMapping("/subscribes")
    public List<Subscribe> addSubscription() {
        return subscribeService.subscribes();
    }

    @GetMapping("/companies")
    public List<Company> companies() {
        return companyService.companies();
    }
}
