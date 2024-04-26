package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "carts")
public class Cart extends BaseEntity{
    @OneToOne(mappedBy = "cart")
    private Payment payment;

    @ManyToMany
    @JoinTable(name = "cart_item_rel",
    joinColumns = @JoinColumn(name = "c_id"),
    inverseJoinColumns = @JoinColumn(name = "i_id"))
    private List<Item> itemList;
}
