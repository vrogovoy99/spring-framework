package com.cydeo.bootstrap;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import com.cydeo.repository.MovieRepository;
import com.cydeo.repository.TicketRepository;
import com.cydeo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DataGenerator implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public DataGenerator(MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        callMovieRepository();
        callTicketRepository();
        callUserRepository();

        System.out.println("");



    }

    private void callUserRepository(){

        System.out.println("------------------- USER DERIVED QUERIES -------------------");

        System.out.println("\n------------------- user by email  -------------------");
//        System.out.println(userRepository.findFirstByEmail("josie_story@email.com"));
    }
    private void callTicketRepository() {
        System.out.println("------------------- TICKET DERIVED QUERIES -------------------");

        System.out.println("\n------------------- tickets per user  -------------------");
//        System.out.println(userRepository.findById(1L).ifPresent(getUsername() + " has " + ticketRepository.countByUser(userRepository.getById(1L)) + " tickets.");

        System.out.println("\n-------------------  list all tickets by specific email  -------------------");
//        ticketRepository.findByUser_Email("josie_story@email.com")
//                .stream().forEach(t-> System.out.println(t.getUser().getEmail()));
        System.out.println(ticketRepository.findByUser_Email("josie_story@email.com"));

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
