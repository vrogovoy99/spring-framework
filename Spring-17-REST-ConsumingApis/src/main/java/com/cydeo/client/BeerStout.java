package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://api.sampleapis.com/beers/",name = "BEER-CLIENT")
public interface BeerStout {

    @GetMapping("/stouts")
    List<User> getBeer();
}
