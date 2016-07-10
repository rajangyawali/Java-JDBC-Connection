/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.all;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectRecords {

    public SelectRecords() {
    }
    private final Connection conn = null;
    private Statement stmt = null;

    void select() throws ClassNotFoundException {
        try {
            System.out.println("Enter database name :");
            Scanner in = new Scanner(System.in);
            String dname = in.nextLine();
            String JDBC_URL = "jdbc:mysql://localhost/" + dname;
            jdbcInitializer init = new jdbcInitializer();
            stmt = init.startConnection(JDBC_URL, conn, stmt);
            System.out.println("Database with name " + dname + " has been selected successfully.");
            System.out.println("Select the table where you want to select records.");
            String tname = in.nextLine();
            System.out.println("The table "+tname +" has been selected.");
            String sql = "SELECT * FROM "+tname;
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " );
                }
                System.out.println("");
            }
            
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

}
