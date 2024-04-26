package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item extends BaseEntity{
    private String code;
    private String name;

    @ManyToMany(mappedBy = "itemList")
    private List<Cart> cartList;

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
