package com.cydeo.bootstrap;

import com.cydeo.entity.Account;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final MovieCinemaRepository movieCinemaRepository;

    public DataGenerator(AccountRepository accountRepository, MovieCinemaRepository movieCinemaRepository) {
        this.accountRepository = accountRepository;
        this.movieCinemaRepository = movieCinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------------------------------------");
//        System.out.println(movieCinemaRepository.findById(1L));

    }
}
