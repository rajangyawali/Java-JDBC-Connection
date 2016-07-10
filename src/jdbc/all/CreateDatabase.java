/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.all;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author rajan
 */
class CreateDatabase {
        private final Connection conn = null;
        private Statement stmt = null;
    public CreateDatabase() {
    }

    public void create() throws SQLException, ClassNotFoundException {
        try{
      jdbcInitializer init = new jdbcInitializer();
      stmt =  init.defaultStartConnection(conn, stmt);
      System.out.println("Enter database name :");
      Scanner in = new Scanner(System.in);
      String name = in.nextLine();
      String sql = "CREATE DATABASE "+name;
      stmt.executeUpdate(sql);
      System.out.println("Database with name "+name + " has been created successfully.");
      if(conn!=null)
      conn.close();
        }catch(SQLException se){
            
        }
    }
    
    
    
}
