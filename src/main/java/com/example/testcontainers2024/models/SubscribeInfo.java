package com.example.testcontainers2024.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "subscribeinfo")
@Data
public class SubscribeInfo {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne()
    @JoinColumn(name = "sub_id", referencedColumnName = "sub_id", foreignKey = @ForeignKey(name = "subscribe_fk", value = ConstraintMode.CONSTRAINT))
    private Subscribe sub_id;
    @ManyToOne()
    @JoinColumn(name = "subs_id", referencedColumnName = "subs_id", foreignKey = @ForeignKey(name = "subscriber_fk", value = ConstraintMode.CONSTRAINT))
    private Subscriber subs_id;
}
