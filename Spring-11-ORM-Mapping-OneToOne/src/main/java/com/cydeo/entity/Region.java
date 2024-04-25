package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int region_id;
    @Column(columnDefinition = "varchar(20)")
    public String region;
    @Column(columnDefinition = "varchar(20)")
    public String country;
}
