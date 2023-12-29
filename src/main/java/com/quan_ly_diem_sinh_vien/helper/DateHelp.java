/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.helper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class DateHelp {

    public static Date convertDate(String dateString) {
        Date sqlDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate;
        try {
            utilDate = dateFormat.parse(dateString);
            sqlDate = new Date(utilDate.getTime());
        } catch (ParseException err) {
            err.printStackTrace();
        } finally {
            return sqlDate;
        }
    }
}
