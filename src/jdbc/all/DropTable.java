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
class DropTable {

    public DropTable() {
    }
    private final Connection conn = null;
    private Statement stmt = null;
    
   void drop() throws ClassNotFoundException {
        try {
            System.out.println("Enter database name :");
            Scanner in = new Scanner(System.in);
            String dname = in.nextLine();
            String JDBC_URL = "jdbc:mysql://localhost/" + dname;
            jdbcInitializer init = new jdbcInitializer();
            stmt = init.startConnection(JDBC_URL, conn, stmt);
            System.out.println("Database with name " + dname + " has been selected successfully.");
            System.out.println("");
            System.out.println("Type the name of table you want to delete.");
            String tname = in.nextLine();
            String sql = "DROP TABLE "+tname;
            stmt.executeUpdate(sql);
            System.out.println("The table "+tname + "has been deleted succesfully.");
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {

        }
    }

}

