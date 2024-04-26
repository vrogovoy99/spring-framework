package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customers")
@NoArgsConstructor
@Data
public class Customer extends BaseEntity {
    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

    public Customer(String address, String email, String name, String surName, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
    }

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    private List<Payment> paymentList;
}
