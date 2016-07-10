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

public class CreateTable {

    public CreateTable() {
    }
    private final Connection conn = null;
    private Statement stmt = null;

    void create() throws ClassNotFoundException {
        try {
            System.out.println("Enter database name :");
            Scanner in = new Scanner(System.in);
            String dname = in.nextLine();
            String JDBC_URL = "jdbc:mysql://localhost/" + dname;
            jdbcInitializer init = new jdbcInitializer();
            stmt = init.startConnection(JDBC_URL, conn, stmt);
            System.out.println("Database with name " + dname + " has been selected successfully.");
            System.out.println("Type the sql for creating the table. This one is sample.");
            System.out.println("\"CREATE TABLE table_name \" +\n"
                    + "                   \"(columnI dataType not NULL, \" +\n"
                    + "                   \" columnII dataType(length), \" + \n"
                    + "                   \" PRIMARY KEY (column ))\";");
            
            System.out.println("");
            String sql = in.nextLine();
            stmt.executeUpdate(sql);
            System.out.println("The table has been created successfully.");
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {

        }
    }

}
