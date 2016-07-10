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
public class DropDatabase {
    
    private final Connection conn = null;
    private Statement stmt = null;
    public DropDatabase() {
    }
   

    void drop() throws ClassNotFoundException {
       try{
      System.out.println("Enter database name you want to delete:");
      Scanner in = new Scanner(System.in);
      String name = in.nextLine();
      jdbcInitializer init = new jdbcInitializer();
      stmt = init.defaultStartConnection(conn, stmt);
      String sql = "DROP DATABASE "+name;
      stmt.executeUpdate(sql);
      System.out.println("Database with name "+name + " has been deleted successfully.");
      if(conn!=null)
      conn.close();
        }catch(SQLException se){
            
        }
    }
    
    
    
}
