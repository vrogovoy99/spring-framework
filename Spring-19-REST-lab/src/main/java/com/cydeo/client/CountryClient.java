package com.cydeo.client;

import com.cydeo.dto.country.CountryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

//https://restcountries.com/v3.1/name/deutschland

@FeignClient(url = "https://restcountries.com/v3.1/name",name = "COUNTRY-CLIENT")
public interface CountryClient {

    @GetMapping("/{countryName}")
    List<Map<String,Object>> getCountryInfo(@PathVariable("countryName") String countryName);
//    List<CountryResponse> getCountryInfo(@PathVariable("countryName") String countryName);
}
