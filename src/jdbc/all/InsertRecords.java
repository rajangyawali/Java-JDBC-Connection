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

public class InsertRecords {

    public InsertRecords() {
    }
    private final Connection conn = null;
    private Statement stmt = null;

    void insert() throws ClassNotFoundException {
        try {
            System.out.println("Enter database name :");
            Scanner in = new Scanner(System.in);
            String dname = in.nextLine();
            String JDBC_URL = "jdbc:mysql://localhost/" + dname;
            jdbcInitializer init = new jdbcInitializer();
            stmt = init.startConnection(JDBC_URL, conn, stmt);
            System.out.println("Database with name " + dname + " has been selected successfully.");
            System.out.println("Select the table where you want to insert records.");
            String tname = in.nextLine();
            System.out.println("The table "+tname +" has been selected.");
            System.out.println("Enter the number of records you want to insert");
            int recNum = in.nextInt();
            System.out.println("Insert the number of columns of your table. ");
            int colNum = in.nextInt();
            System.out.println("Insert the records column wise"
                    + " and put comma after each record except last. ");
            
            for(int i = 0; i< recNum ; i++){
                String[] records = new String[colNum];
                String value = "";
                System.out.println("Enter another record.");
                for(int j = 0;j<colNum;j++){
                    records[j] = in.nextLine();
                    value = value + records[j];
                }
                String sql = "INSERT INTO "+tname +" VALUES("+value+");";
                stmt.executeUpdate(sql);
                
            }
            System.out.println("The records have been inserted.");
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {

        }
    }

}
