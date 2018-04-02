package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {
    private int id;
    private String name;

    private List<Item> item = new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            //cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItem() {
        return item;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
