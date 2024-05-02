package org.cydeo.bootstrap;

import org.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----------Region Start ------------------");
        System.out.println("   find by country: " + regionRepository.findByCountry("Canada"));
        System.out.println("-----------Region with USA");
        regionRepository.findDistinctByCountry("United States").stream().forEach(r-> System.out.println("USA region: " + r.getRegion()));
        System.out.println("-----------Region where country contains United");
        regionRepository.findByCountryContains("United")
                .stream().forEach(r-> System.out.println("Region with contry containing united: " + r.getRegion()));
        System.out.println("-----------Region where country contains United in order");
        regionRepository.findByCountryContainsOrderByCountry("Asia")
                .stream().forEach(r-> System.out.println("Region with contry containing asia: " + r.getRegion()));
        System.out.println("-----------Top 2 Region where country is United");
        regionRepository.findTop2ByCountry("United States")
                .stream().forEach(r-> System.out.println("Top 2 Regions with contry United States: " + r.getRegion()));



        System.out.println("-----------Region End ------------------");



    }
}
