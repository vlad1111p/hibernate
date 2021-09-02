package com.incalss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationUtil {

    public static Connection getConnection(){

        String url = "jdbc:mysql://localhost:3306/coffee_store";
        String user = "root";
        String pass = "qazwsx";

        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("conn is successful");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
