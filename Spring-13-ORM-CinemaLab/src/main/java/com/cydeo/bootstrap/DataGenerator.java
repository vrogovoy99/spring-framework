package com.cydeo.bootstrap;

import com.cydeo.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public DataGenerator(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        callMovieRepository();



    }

    private void callMovieRepository(){
        System.out.println("------------------- MOVIE DERIVED QUERIES -------------------");
        movieRepository.findByNameContaining("The")
                .stream().forEach(p-> System.out.println(p.getName()));

    }
}
