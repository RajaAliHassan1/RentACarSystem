/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

/**
 *
 * @author Ali Hassan
 */
import java.util.Date;

public class myDate {
    
    private int day;
    private int month;
    private int year;

    public myDate() {
        
        Date set = new Date();
        this.day = set.getDay();
        this.month = set.getMonth();
        this.year = set.getYear();
        
    }

    public myDate(String date) {
         
        String ar[]= date.split("-");
        
        
        this.day = Integer.parseInt(ar[2]);
        this.month = Integer.parseInt(ar[1]);
        this.year = Integer.parseInt(ar[0]);
    
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public long getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  this.year+"-"+this.month+"-"+this.day;
    }
    
    
    
}
