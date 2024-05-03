package com.managementSystem.poc;

import java.sql.*;
public class Connect {
    Connection c;
    Statement s;
    public Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///bank","root","Harish@02");
            s=c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
