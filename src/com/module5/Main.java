package com.module5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/to_do_application?useSSL=false";
        String user = "root";
        String pass = "admin123";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("connect succcess!!");
        } catch (Exception e) {
            e.printStackTrace();
        }











    }
}
