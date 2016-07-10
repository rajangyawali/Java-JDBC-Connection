/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.all;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author rajan
 */
public class JDBCAll {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while(true){
        System.out.println("Welcome to the JDBC program. Please enter your choice 1 - 12 ");
        System.out.println("1. Create Database");
        System.out.println("2. Select Database");
        System.out.println("3. Drop Database");
        System.out.println("4. Create Table");
        System.out.println("5. Drop Table");
        System.out.println("6. Insert Records ");
        System.out.println("7. Select Records ");
        System.out.println("");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch (choice) {

            case 1:
                CreateDatabase cd = new CreateDatabase();
                cd.create();
                break;

            case 2:
                SelectDatabase sd = new SelectDatabase();
                sd.select();
                break;
            case 3:
                DropDatabase dd = new DropDatabase();
                dd.drop();
                break;
            case 4:
                CreateTable ct = new CreateTable();
                ct.create();
                break;
            case 5:
                DropTable dt = new DropTable();
                dt.drop();
                break;
            case 6:
                InsertRecords ir = new InsertRecords();
                ir.insert();
                break;
            case 7:
                SelectRecords sr = new SelectRecords();
                sr.select();
                break;
        }

    }
    }

}
