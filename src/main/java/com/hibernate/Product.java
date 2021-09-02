package com.hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "price", precision = 3, scale = 2)
    private BigDecimal price;

    @Column(name = "coffee_origin", length = 20)
    private String coffeeOrigin;

    public Product(String name, BigDecimal price, String coffeeOrigin) {
        this.name = name;
        this.price = price;
        this.coffeeOrigin = coffeeOrigin;
    }

    public Product() {

    }

    public void setCoffeeOrigin(String coffeeOrigin) {
        this.coffeeOrigin = coffeeOrigin;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}