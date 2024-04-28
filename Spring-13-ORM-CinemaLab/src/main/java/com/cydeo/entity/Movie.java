package com.cydeo.entity;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity{
    private Integer duration;
    private String name;
    private Long price;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    @Enumerated(value=EnumType.STRING)
    private State state;
    private String summary;
    @Enumerated(value=EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "movieList")
    private List<Genre> genreList;
    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinemaList;
}
