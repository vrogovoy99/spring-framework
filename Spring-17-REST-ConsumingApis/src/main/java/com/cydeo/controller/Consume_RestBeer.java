package com.cydeo.controller;

import com.cydeo.dto.Beer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/beer")
public class Consume_RestBeer {
    //define api json source uri
    private final String URI="https://api.sampleapis.com/beers/stouts";
    //inject RestTemplate bean
    private final RestTemplate restTemplate;

    public Consume_RestBeer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //map the http call
    @GetMapping
    public Beer[] readAllBeer(){
        ResponseEntity<Beer[]> responseEntity=restTemplate.getForEntity(URI, Beer[].class);
        return responseEntity.getBody();
    }

    @GetMapping("{id}")
    public Beer readById(@PathVariable("id") Integer id){
        ResponseEntity<Beer> responseEntity=restTemplate.getForEntity(URI + "/" + id, Beer.class);
        return responseEntity.getBody();
    }

    @GetMapping("/object/{id}")
    public Object readObjectById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(URI + "/" + id, Object.class, id);
    }



}
