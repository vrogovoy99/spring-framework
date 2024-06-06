package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);


    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String name);


    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findByLocation_Country(String country);


    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsor);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c WHERE id = ?1")
    List<String> retrieveNameByID(Long id);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinema c WHERE c.location_id in (SELECT id FROM location WHERE country = ?1) ", nativeQuery = true)
    List<Cinema> getByCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM cinema WHERE name ilike '%'||?1||'%' OR sponsored_name ilike '%'||?1||'%' ", nativeQuery = true)
    List<Cinema> getByCountry1(String country);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM cinema ORDER BY name", nativeQuery = true)
    List<Cinema> getByCountry2(String country);

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT distinct sponsored_name FROM cinema", nativeQuery = true)
    List<String> getByCountry3(String country);

}
