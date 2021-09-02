package com.incalss;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductRepository {

    public int insertProduct(Product product) {
        String sql = "insert into products values(?,?,?,?)";

        try (PreparedStatement pstmt = ConfigurationUtil.getConnection().prepareStatement(sql)){
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getCoffee_origin());
            return pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void updateProduct(int id,String name){
        String sql= "update products set name= " +  "'" +name+ "'" +" where id= " + id+";";

        try(Statement stmt = ConfigurationUtil.getConnection().createStatement()){
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
