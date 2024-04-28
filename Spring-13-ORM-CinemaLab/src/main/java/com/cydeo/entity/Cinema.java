package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Cinema extends BaseEntity{
    private String name;
    private String sponsored_name;
    @ManyToOne
    private Location location;
    @OneToMany(mappedBy = "cinema")
    private List<MovieCinema> movieCinemaList;
}
