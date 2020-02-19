/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Raja Ali Hassan
 * 
 * THIS IS A CLASS FOR AVAILING THE FIVESTAR PACKAGE WHICH CAN ONLY BE AVAILED BY 
 * USER OLDER THAN 5 MONTHS AND HAS A ACCOUNT HISTORY OF MORE THAN RS 5,000 
 * IT GIVES USER
 *     -15% DISCOUNT ON LUXURY CARS 
 *     -5%  DISCOUNT ON MIDDEL CARS
 *     -0%  DISCOUNT ON ECONOMY CARS
 * 
 */
public class ThreeStarBooking extends Booking{
         
        static int count;   
        boolean Drivercheck; // TRUE IN CASE USER SELECTS DRIVER FALSE IN CASE USER DOES NOT SELECT DRIVER
    
    public ThreeStarBooking() throws IOException, FileNotFoundException, ClassNotFoundException {
    }

    public ThreeStarBooking(Car cars,Driver driver, Accounts account, int daysReserve, int hoursReserve, boolean dayORhour, User cost,boolean Drivercheck) throws IOException, FileNotFoundException, ClassNotFoundException {
        super( cars, driver, account, daysReserve, hoursReserve, dayORhour, cost);
        this.Drivercheck = Drivercheck; 
    }

    
    
    
    @Override
    public boolean check ()throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{ 
     
     myDate date = this.getCostomer().getRegistrationDate();
     myDate now = new myDate();
     long c = 5000;
     int time = now.getMonth() -date.getMonth();
           
            if (5 == time || time >5 ) {
                if(this.gettotalBookingsAmountHistory() >=  c){
                              return true;
                } }
            else {
            
                    return false;
            }      
            return false;
                   
            

    }
    @Override
    public double calculateTotalRent() {
      
             double total = 0;
             double rentinEco = 0;
             double rentinLux = 0;
             double rentinMid = 0;
             double DFare = 0;
             
                      //TRUE FOR HOURS 
                if ( this.isDayORhour() == true   ){
                        
                           if (this.getCars().getEcoType() == CarType.ECONOMY){
                           
                               rentinEco = (this.getHoursReserve()*this.getCars().getRentperHour()) + total;
                               
                           
                                     //15% DISCOUNT                               
                           if (this.getCars().getEcoType() == CarType.LUXURY){
                           
                               rentinLux = (this.getHoursReserve()*this.getCars().getRentperHour()) + total;
                           }
                                     //5%  DISCOUNT
                           if (this.getCars().getEcoType() == CarType.MIDDLE){
                               
                               rentinMid = (this.getHoursReserve()*this.getCars().getRentperHour()) + total;
                           
                           }    
                }
                }
                     //FALSE IF DAYS
                if ( this.isDayORhour() == false   ){
                        
                           if (this.getCars().getEcoType() == CarType.ECONOMY){
                           
                               rentinEco = (this.getDaysReserve()*this.getCars().getRentPerDay()) + total;
                               
                           }
                                     //15% DISCOUNT                               
                           if (this.getCars().getEcoType() == CarType.LUXURY){
                           
                               rentinLux = (this.getDaysReserve()*this.getCars().getRentPerDay()) + total;
                           }
                                     //5%  DISCOUNT
                           if (this.getCars().getEcoType() == CarType.MIDDLE){
                               
                               rentinMid = (this.getDaysReserve()*this.getCars().getRentPerDay()) + total;
                           
                           }
                }
        
             
           
    
                JOptionPane.showMessageDialog(null, "Total Bill "+total);
                this.setBill(total);
                total = rentinEco + (rentinLux *0.15)+(rentinMid*0.5)+DFare;
                return total;  
    }
    
    
//METHOD TO EDIT THE ACCOUNT OF THE USER ACCORDING TO THE RENT 
    @Override
    public void PayAccount() throws ClassNotFoundException,IOException {
    
    double credit=0;
    double balance = 0;
    double rent = this.calculateTotalRent();
    
    if( this.getAccount().getBalance() == 0  && this.getAccount().getCredit() ==0){
          credit =  rent; 
          balance =0;
      }
      
      if( this.getAccount().getBalance() < rent && this.getAccount().getCredit() == 0   && this.getAccount().getBalance() !=0  ){
          
             credit = rent- this.getAccount().getBalance() ;
             balance =0;
      }
      
      if(this.getAccount().getCredit() > 0 && this.getAccount().getBalance() == 0   ){
     
      credit = this.getAccount().getCredit()+rent;
      balance = 0 ; 
      }
           this.getAccount().setBalance(balance);
           this.getAccount().setCredit(credit);
          try { this.getAccount().upDateAccount();
          }
          catch(Exception ee){JOptionPane.showMessageDialog(null, ee.getMessage());}
           
    
        
   
    
    
    
    }

    @Override
    public void UnPayAccount() throws ClassNotFoundException, IOException {

double credit = 0;
    double balance;
    double rent = this.getBill();
      if( this.getAccount().getBalance() == 0  && this.getAccount().getCredit() ==0){
          balance = this.getAccount().getBalance() + rent; 
          this.getAccount().setBalance(balance);
          this.getAccount().setCredit(0);
      }
      
      if( this.getAccount().getBalance() < rent && this.getAccount().getCredit() == 0){
          balance = rent+ this.getAccount().getBalance() ;
          this.getAccount().setBalance(balance);
          this.getAccount().setCredit(0);
      
      }
      
      if(this.getAccount().getCredit() > rent && this.getAccount().getBalance() == 0  ){
      credit = rent-this.getAccount().getCredit();
      this.getAccount().setBalance(0);
      this.getAccount().setCredit(credit);
      
      }
      if(this.getAccount().getCredit() < rent && this.getAccount().getBalance() == 0 && this.getAccount().getCredit()> 0  ){
      
      credit = this.getAccount().getCredit()-rent;
      this.getAccount().setBalance(credit);
      this.getAccount().setCredit(0);
      
      }
      
         this.getAccount().upDateAccount();}
    

}