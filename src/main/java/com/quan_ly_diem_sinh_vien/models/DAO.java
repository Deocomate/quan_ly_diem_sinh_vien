/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DAO {

    protected static String hostName = "localhost:3307";
    protected static String dbName = "quan_ly_dien_sinh_vien_test";
    protected static String username = "root";
    protected static String password = "";
    protected static String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public static Connection connect() {
        // Connect đến database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            System.out.println("Kết nối không thành công");
        }
        return conn;
    }

}
