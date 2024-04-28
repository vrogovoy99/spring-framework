package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Location extends BaseEntity{
    private String name;
    private String address;
    private String postalCode;
    private String country;
    private String state;
    private String city;

//    OneToMany not required, since relationship is contorlled b the other side
//    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
//    private List<Cinema> cinemaList;

}
