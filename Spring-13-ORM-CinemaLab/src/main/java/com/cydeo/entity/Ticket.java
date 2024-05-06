package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity{
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateTime;
    private Integer seatNumber;
    private Integer rowNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private User user;
}
