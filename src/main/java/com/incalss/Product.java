package com.incalss;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private double price;
    private String coffee_origin;

    public Product(String name, double price, String coffee_origin) {
        this.name = name;
        this.price = price;
        this.coffee_origin = coffee_origin;
    }
    public Product(){

    }
}
