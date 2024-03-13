package com.example.testcontainers2024.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Entity
@SoftDelete
@Table(name = "companies")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;
    @Column
    @Check(name = "companies_name_chk", constraints = "NAME IS NOT NULL")
    private String name;
    @Column
    private String phone;
}
