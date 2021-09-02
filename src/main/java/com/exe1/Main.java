package com.exe1;


import java.sql.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConfigurationUtil.getConnection();

        ArrayList<Department> departments = new ArrayList<Department>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<EmployeeProject> employeeProjects = new ArrayList<EmployeeProject>();
        ArrayList<Project> projects = new ArrayList<Project>();

//        try {
//            Statement stmt = conn.createStatement();
//            String sqlDepartments = "Select * from departments";
//            String sqlEmployees = "Select * from employees";
//            String sqlEmployeesProject="Select * from employees_projects";
//            String sqlProjects="Select * from projects";
//            ResultSet rs = stmt.executeQuery(sqlDepartments);
//            ResultSet rs1 = stmt.executeQuery(sqlEmployees);
//            ResultSet rs2 = stmt.executeQuery(sqlEmployeesProject);
//            ResultSet rs3= stmt.executeQuery(sqlProjects);
//
//            while (rs.next()) {
//                Department department = new Department(rs.getInt("departmentId"),
//                        rs.getString("name")
//                       );
//                departments.add(department);
//            }
//            stmt.close();
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        tableToList(conn, "departments");
        tableToList(conn, "employees");
        tableToList(conn, "employees_projects");
        tableToList(conn, "projects");
        String tableName=" employees";

//        ArrayList <Department> newList = new ArrayList<Department>();
//        PreparedStatement statement = conn.prepareStatement("select * from "+ tableName);
//        ResultSet resultSet = statement.executeQuery();

//        if (resultSet != null) {
//            while (resultSet.next()) {
//                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
//
//                    int type = resultSetMetaData.getColumnType(i);
//                    if (type == Types.VARCHAR || type == Types.CHAR) {
//                        newList.add(resultSet.getString(i));
//                    } else {
//                        System.out.println(resultSet.getLong(i));
//                    }
//                }
//
//                System.out.println("-----------");
//            }
//        }
    }



    private static  void  tableToList (Connection conn,String tableName) throws SQLException {
        ArrayList  newList = new ArrayList();
        PreparedStatement statement = conn.prepareStatement("select * from "+tableName);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet != null) {
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

                    int type = resultSetMetaData.getColumnType(i);
                    if (type == Types.VARCHAR || type == Types.CHAR) {
                        newList.add(resultSet.getString(i));
                    } else {
                        System.out.println(resultSet.getLong(i));
                    }
                }

                System.out.println("-----------");
            }
        }
    }

}
