package org.cydeo.repository;

import org.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    //Display all regions in Canada
    List<Region> findByCountry(String country);

    //display all unique regions in country
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name including 'United'
    List<Region> findByCountryContains(String country);

    //Display all regions with country containing 'united' in order
    List<Region> findByCountryContainsOrderByCountry(String country);
    //Display all top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);



}
