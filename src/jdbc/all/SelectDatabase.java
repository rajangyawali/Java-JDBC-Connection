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
public class SelectDatabase {
    
    private final Connection conn = null;
    private Statement stmt = null;
    public SelectDatabase() {
    }
   

    void select() throws ClassNotFoundException {
       try{
      System.out.println("Enter database name :");
      Scanner in = new Scanner(System.in);
      String name = in.nextLine();
      String JDBC_URL = "jdbc:mysql://localhost/"+name;    
      jdbcInitializer init = new jdbcInitializer();
      init.startConnection(JDBC_URL,conn, stmt);
      System.out.println("Database with name "+name + " has been selected successfully.");
      if(conn!=null)
      conn.close();
        }catch(SQLException se){
            
        }
    }
}
