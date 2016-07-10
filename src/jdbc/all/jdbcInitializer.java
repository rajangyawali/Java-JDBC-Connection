/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcInitializer {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String JDBC_URL = "jdbc:mysql://localhost/";
    private final String USER = "root";
    private final String  PASS = "";
    
    public Statement defaultStartConnection(Connection conn , Statement stmt) throws SQLException, ClassNotFoundException{
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to Database....");
            conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
            stmt = conn.createStatement();
            System.out.println("Creating statement");
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
        return stmt;
    }
    
    public Statement startConnection(String JDBC_URL, Connection conn , Statement stmt) throws SQLException, ClassNotFoundException{
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to Database....");
            conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
            stmt = conn.createStatement();
            System.out.println("Creating statement");
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
        return stmt;
    }
    
    public void releaseConnection(Connection conn , Statement stmt) throws SQLException{
        try{
        stmt.close();
        conn.close();
        }catch(SQLException se){
            
        }
         }
  
}
