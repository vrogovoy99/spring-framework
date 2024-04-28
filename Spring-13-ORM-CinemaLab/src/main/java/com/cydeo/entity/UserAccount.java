package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class UserAccount extends BaseEntity{

    @NonNull
    private String email; //TODO:email must be validated
    @NonNull
    private String password; //TODO: minimym 6 characters and can't be null
    @NonNull
    private String username;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accountDetailsId")
    private AccountDetails accountDetails;
    @OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;
}
