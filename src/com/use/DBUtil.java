package com.use;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TruongBDU","Nguyentruong","Nguyentruong2802");
            return connection;
        }catch (Exception e){
            throw new Exception("Connection failure!");
        }
    }
}
