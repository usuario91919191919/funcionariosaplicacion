package com.mycompany.funcionarios.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
    
    private static final String URL = "jdbc:mysql://localhost:3306/funcionarios";
    private static final String USER = "root";
    private static final String PASSWORD = "aguacatote1";
    
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
}
