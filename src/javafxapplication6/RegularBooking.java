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
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raja Ali Hassan

 * 
 * THIS CLASS IS FOR ALL USERS 
 * AND PRICES ARE SAME AS SPECFIED IN THE CAR DESCRIPTION 
 */
public class RegularBooking extends Booking{
    
   private boolean  DriverCheck;
// TRUE IN CASE USER SELECTS DRIVER FALSE IN CASE USER DOES NOT SELECT DRIVER
    public void setDriverCheck(boolean d){
     
        this.DriverCheck = d;
    
    }
    public boolean isDriverCheck(){
    
      return this.DriverCheck;
      
    
    }
   
   
   
   
   
    public RegularBooking() throws IOException, FileNotFoundException, ClassNotFoundException {
    }

    public RegularBooking( Car cars, Driver driver, Accounts account, int daysReserve, int hoursReserve, boolean dayORhour, User cost,boolean DriverCheck) throws IOException, FileNotFoundException, ClassNotFoundException {
        super(cars, driver, account, daysReserve, hoursReserve, dayORhour, cost);
          
          this.DriverCheck = DriverCheck;
          this.bookCars();
          this.PayAccount();
    }
    
    public String getCarName (){
    
       return  this.getCar().getCarName();
    
    }
    public String getCostomerName(){
    
       return this.getCostomer().getName();
    
    }
    
    
    @Override
    
    public double calculateTotalRent() {
    
     
             double total = 0;
             double rentinEco = 0;
             double rentinLux = 0;
             double rentinMid = 0;
             double DFare = 0;  
             
                      //TRUE FOR HOURS 
                if ( this.isDayORhour() == false  ){
                        
                           
                      rentinEco = (this.getHoursReserve()*this.getCars().getRentperHour()) + total;
                               
                }
                
                
                     //FALSE IF DAYS
                if ( this.isDayORhour() == true   ){
                       
                              
                         rentinEco = (this.getDaysReserve()*this.getCars().getRentPerDay()) + total;
                            
                }
        
             
           
                this.setBill(total);
                total = rentinEco;
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
          JOptionPane.showMessageDialog(null, "Your Total Bill"+rent);
          }
          catch(Exception ee){JOptionPane.showMessageDialog(null, ee.getMessage());}
           
        
        
        
   
    
    
    
    }
    
    @Override
    public boolean check() throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{return true;};

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
