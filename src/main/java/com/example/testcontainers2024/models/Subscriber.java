package com.example.testcontainers2024.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Entity
@SoftDelete
@Table(name = "subscribers",uniqueConstraints = {@UniqueConstraint(name = "subscribers_addr_uc",columnNames = {"addr_id"})},indexes =
        {@Index(name = "subscribers_gender_idx", columnList = "gender"),@Index(name = "subscribers_addr_id_idx", columnList = "addr_id"),@Index(name = "mulitIndex1", columnList = "gender, addr_id")})
@Data
public class Subscriber {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID subs_id;
    @Column
    @Check(name = "subscribers_fio_chk", constraints = "FIO IS NOT NULL")
    private String fio;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @OneToOne()
    @JoinColumn(name = "addr_id", referencedColumnName = "addr_id", foreignKey = @ForeignKey(name = "subscribers_address_fk", value = ConstraintMode.CONSTRAINT))
    private Address addr_id;
}
