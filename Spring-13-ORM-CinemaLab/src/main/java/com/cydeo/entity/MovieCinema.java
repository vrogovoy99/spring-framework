package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Cinema cinema;
    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> ticketList;
}
