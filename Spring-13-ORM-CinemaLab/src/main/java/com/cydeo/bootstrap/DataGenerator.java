package com.cydeo.bootstrap;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import com.cydeo.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DataGenerator implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public DataGenerator(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        callMovieRepository();

        System.out.println("");



    }

    private void callMovieRepository(){
        System.out.println("------------------- MOVIE DERIVED QUERIES -------------------");

        System.out.println("\n------------------- movie containing 'The' -------------------");
        movieRepository.findByNameContaining("The")
                .stream().forEach(p-> System.out.println(p.getName()));

        System.out.println("\n------------------- movie price between 20 and 30 'The' -------------------");
        movieRepository.findByPriceBetween(20L,30L)
                .stream().forEach(p-> System.out.println(p.getName() + " - $" + p.getPrice()));

        System.out.println("\n------------------- movie duration between 2 and 3 hours -------------------");
        movieRepository.findByDurationBetween(120,180)
                .stream().forEach(p-> System.out.println(p.getName() + " - min:" + p.getDuration()));

        System.out.println("\n------------------- movie released after 2019-12-12  -------------------");
        movieRepository.findByReleaseDateAfter(LocalDate.of(2019, 12, 12))
                .stream().forEach(p-> System.out.println(p.getName() + " - release on: " + p.getReleaseDate()));

        System.out.println("\n------------------- movie list all movies with a REGULAR state and ACTIVE type  -------------------");
        movieRepository.findByTypeAndState(Type.REGULAR, State.ACTIVE)
                .stream().forEach(p-> System.out.println(p.getName() + " - " + p.getState()  + " - " + p.getType()));

        System.out.println("\n------------------- movies between a range of prices 20-40 -------------------");
        movieRepository.jpqlPriceRange(20L, 40L)
                .stream().forEach(p-> System.out.println(p.getName() + " - $" + p.getPrice()));

        System.out.println("\n------------------- movies name list -------------------");
        movieRepository.jpqlListOfNames()
                .stream().forEach(System.out::println);



    }
}
