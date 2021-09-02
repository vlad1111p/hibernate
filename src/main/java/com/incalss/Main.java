package com.incalss;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConfigurationUtil.getConnection();
        List<Product> products = new ArrayList<Product>();

        try {
            Statement stmt = ConfigurationUtil.getConnection().createStatement();
            String sql = "Select * from products";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("coffee_origin"));
                products.add(product);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Product product1 = new Product(30,"cappusdccino",12.50,"Ramnicud Sarat");


        ProductRepository productRepository = new ProductRepository();
        if(productRepository.insertProduct(product1)>0){
            System.out.println(product1.toString());


        }
        productRepository.updateProduct(4,"asffxasd");
    }
}
