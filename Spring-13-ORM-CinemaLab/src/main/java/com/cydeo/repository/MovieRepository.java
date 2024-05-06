package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //


    //Write a derived query to read a movie with a name
    List<Movie> findByNameContaining(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findByPriceBetween(Long startPrice, Long endPrice);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findByDurationBetween(Integer startDuration, Integer endDuration);

    //Write a derived query to list all movies with higher than a specific release date

    List<Movie> findByReleaseDateIsGreaterThanEqualOrderByReleaseDate(LocalDate LocalDatecutOffDate );

    List<Movie> findByReleaseDateAfter(LocalDate cutOffDate );



    //Write a derived query to list all movies with a specific state and type
    List<Movie> findByTypeAndState(Type type, State state);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price between ?1 and ?2")
    List<Movie> jpqlPriceRange(Long startPrice, Long endPrice);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m ORDER BY m.name")
    List<String> jpqlListOfNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name

    //Write a native query that return the list of movies in a specific range of prices

    //Write a native query to return all movies where duration exists in the range of duration

    //Write a native query to list the top 5 most expensive movies

}
