package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity{

    @NonNull
    private String email; //TODO:email must be validated
    @NonNull
    private String password; //TODO: minimym 6 characters and can't be null
    @NonNull
    private String username;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
