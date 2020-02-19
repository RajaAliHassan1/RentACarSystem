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

     //Imported Files
import java.io.EOFException;
import java.io.File;
import java.util.Date;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;


public abstract class Booking implements Serializable{
    //Attributes 
    private int id;
    private Car car;
    private User costomer;
    private Driver  driver;
    private Accounts account;
    private int daysReserve;
    private int hoursReserve;
    private boolean dayORhour; //True if Hours False if Day;
    private double bill;
    
    protected final double driverFarePerDay = 1500;
    protected final double driverFarePerHour = 15 ;
    //Constructors

    public Booking()  {
        
    }

    public Booking(Car car, Driver driver, Accounts account, int daysReserve,
    int hoursReserve, boolean dayORhour,User cost) 
    throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Random random = new Random();
        this.id= random.nextInt(100);
        this.car = car;
        this.driver = driver;
        this.account = account;
        this.daysReserve = daysReserve;
        this.hoursReserve = hoursReserve;
        this.dayORhour = dayORhour;
        this.costomer = cost;
        
     
    }
    
    //SETTER METHODS 

    
    public void setBill(double bill) {
        this.bill = bill;
    }
    
    public void setCostomer(User costomer) {
        this.costomer = costomer;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCars(Car cars) {
        this.car = cars;
    }

   
    public void setAccount(Accounts account) {
        this.account = account;
    }

    public void setDaysReserve(int daysReserve) {
        this.daysReserve = daysReserve;
    }

    public void setHoursReserve(int hoursReserve) {
        this.hoursReserve = hoursReserve;
    }

    public void setDayORhour(boolean dayORhour) {
        this.dayORhour = dayORhour;
    }

    public Car getCar() {
        return car;
    }

    //GETTER METHODS
   

    public double getBill() {
        return bill;
    }
    
    public User getCostomer() {
        return costomer;
    }

    public int getId() {
        return id;
    }

    public Car getCars() {
        return car;
    }

   
    public Accounts getAccount() {
        return account;
    }

    public int getDaysReserve() {
        return daysReserve;
    }

    public int getHoursReserve() {
        return hoursReserve;
    }

    public boolean isDayORhour() {
        return dayORhour;
    }
    
    
    //Search Bookings
    //fit
    public RegularBooking searchBooking(int BookingId) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{
    
         
    File f = new File("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Bookings.bin");
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Bookings.bin");
        in = new Scanner(file);
        
        int j = 0;
        String a;
        String []aac ;
        String target = null;
        
        while (in.hasNext()) {
      a= in.nextLine();
            aac = a.split("=");
            if (Integer.parseInt(aac[0]) == BookingId){
               target = a;
            }
            
             
            j++;
        }
        String ser = null;
        in.close();
        file.close();
        Car set = new Car();
        Driver sett = new Driver();
        User settt = new User();
        Accounts setttt = new Accounts();
        RegularBooking obj = new RegularBooking();
        
        int i = 0;
       if (target == null){
          return null;
       } 
              //
        String[] ac = target.split("=");
        int id = Integer.parseInt(ac[0]);
        Car car = set.searchCar(Integer.parseInt(ac[1]));
        User costomer = settt.searchUser(Integer.parseInt(ac[2])); 
        
        Accounts account = setttt.searchbyBookID(Integer.parseInt(ac[3]));
        int daysReserve;
         daysReserve = Integer.parseInt(ac[4]);
       int hoursReserve;
           hoursReserve = Integer.parseInt(ac[5]);
        boolean dayORhour = false;
        if(ac[6].equals("true")){ dayORhour =true;}
        if(ac[6].equals("false")){ dayORhour =false;} 
        double bill = Double.parseDouble(ac[7]);
   
        obj.setAccount(account);obj.setId(id); obj.setCars(car); obj.setDayORhour(dayORhour);
        obj.setDaysReserve(daysReserve); obj.setHoursReserve(hoursReserve); obj.setBill(bill); obj.setCostomer(costomer);
    
        return obj;
       
    }
    
    
    //Method to Add Booking in The System 
    public void addBooking( RegularBooking objj) throws FileNotFoundException, IOException, ClassNotFoundException{
       //EXCEPTION IN ADD BOOKINGS
        
      try{
      
        File f = new File("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Bookings.bin");
        Vector<String> read = new Vector<>();
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Bookings.bin");
  in = new Scanner(file);

        while (in.hasNext()) {
            read.add(in.nextLine());
        
        }
        in.close();
        
        file.close();

        f.delete();
        
        f.createNewFile();
        String ad;
//    
        //
 ad = objj.getId() + "=" + objj.getCars().getId()+
 "=" + objj.getCostomer().getId() 
+"="+objj.getAccount().getId()+ "=" + objj.getDaysReserve() + "=" + objj.getHoursReserve() + "=" + objj.isDayORhour()+"="+objj.calculateTotalRent();
        
        read.add(ad);
 
        PrintWriter out = new PrintWriter("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Bookings.bin");
        int i = 0;

        while (i < read.size()) {
        
            out.println(read.get(i));
            i++;

        }
        out.close();

      }
      catch (FileNotFoundException yy ){JOptionPane.showMessageDialog(null, "FileNotFound");}
      catch(IOException rr ){JOptionPane.showMessageDialog(null, "IO");}
    }
    //Method to Update Booking in the System 
    public void updateBooking() throws FileNotFoundException, IOException, ClassNotFoundException{
     
         int re = 0;
        File f = new File("Bookings.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Bookings.bin");
        in = new Scanner(file);
        int j = 0;
        while (in.hasNext()) {

            read.add(in.nextLine());
            j++;
        }

        in.close();
        file.close();
        f.delete();
        f.createNewFile();
        int i = 0;
        for (String aa : read) {

            data = aa.split("=");
            if (Integer.parseInt(data[0]) == this.id) {

                re = i;

            }
            data = null;
            i++;
        }
        read.remove(re);

        String add;

       // add = this.getId() + "=" + this.car.getId() +
 //"=" + this.getCostomer().getId() + "=" + this.getDriver().getId() +
// "=" + this.getDaysReserve() + "=" + this.getHoursReserve() + "=" + this.isDayORhour()+"="+this.getBill()+"="+this.isDriverCheck();
 
   //     read.add(add);

        PrintWriter out = new PrintWriter("Bookings.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

      
    }
    //Method to Delete Booking from the System 
    public void deleteBooking() throws IOException, ClassNotFoundException, FileNotFoundException, ParseException{
    
        
        this.undoBookCar();
        this.UnPayAccount();
        int re = 0;
        File f = new File("Bookings.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Bookings.bin");
        in = new Scanner(file);
        int j = 0;
        while (in.hasNext()) {
           read.add(in.nextLine());
            j++;
        }

        in.close();
        file.close();
        f.delete();
        f.createNewFile();
        int i = 0;
        for (String aa : read) {

            data = aa.split("=");
            if (Integer.parseInt(data[0]) == this.getId()) {
        re = i;

            }
            data = null;
            i++;
        }
        read.remove(re);
    PrintWriter out = new PrintWriter("Bookings.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;
        }
        out.close();

        
    }
    
    //Method to Return All Bookings as ArrayList 
    public Vector<RegularBooking> allBookings() throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{
        File f = new File("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Bookings.bin");
        Vector<String> read = new Vector<>();
        Vector<RegularBooking> send = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Bookings.bin");
        in = new Scanner(file);
        int j = 0;

        while (in.hasNext()) {
       String b = in.nextLine();
       read.add(b);
            j++;
        }
        String ser = null;
        in.close();
        file.close();
        Car set = new Car();
        Driver sett = new Driver();
        User settt = new User();
        Accounts setttt = new Accounts();
        int i = 0;
        for (String aa : read) {
        
            
        String[] ac = aa.split("=");
        int id = Integer.parseInt(ac[0]);
        Car car = set.searchCar(Integer.parseInt(ac[1]));
        User costomer = settt.searchUser(Integer.parseInt(ac[2])); 
        Accounts account = setttt.searchbyBookID(Integer.parseInt(ac[3]));
        int daysReserve = Integer.parseInt(ac[4]);
        int hoursReserve = Integer.parseInt(ac[5]);
        boolean dayORhour = false;
        if(ac[6].equals("true")){ dayORhour =true;}
        if(ac[6].equals("false")){ dayORhour =false;} 
        double bill = Double.parseDouble(ac[7]);
  
    
        RegularBooking obj = new RegularBooking();
        obj.setAccount(account);obj.setId(id); obj.setCars(car);  obj.setDayORhour(dayORhour);
        obj.setDaysReserve(daysReserve); obj.setHoursReserve(hoursReserve); obj.setBill(bill); obj.setCostomer(costomer);
        send.add(obj);
 
        }
 return send;

    
     
        
     }
    
    //Method to Booking Cars and Update the Cars Data File  
    public void bookCars() throws IOException, FileNotFoundException, ClassNotFoundException{
           
        
            this.getCars().setAvailibility(Status.BOOKED);
           this.getCars().setCostomerId(this.costomer.getId());
         
         this.getCars().updateCar();
            
        
   
    }
    //Method to Book a Driver and Update the Drivers Data File
    
    //METHOD USED TO FREE THE STATUS OF THE CAR IN CASE OF AND UPDATE OR CANCELATION
    public void undoBookCar() throws IOException, FileNotFoundException, ClassNotFoundException, ParseException{
           
        
            this.getCars().setAvailibility(Status.AVAILABLE);
            this.getCars().setCostomerId(0);
            this.getCars().updateCar();
        
        
   
    }
    //METHOD TO GET THE TOTAL AMOUNT HISTORY OF A PERTICULAR USER
     public long gettotalBookingsAmountHistory() throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{
 
      long total = 0;
      
         for (RegularBooking aa : this.allBookings()){
         
             int id = aa.getCostomer().getId();
            if (id == this.costomer.getId()){
            
                total = (long) (aa.getBill() + total);
            
            }               
             
         }
         return total;
     }
     //Mthod to return a Specfi Users Bookings
 public Vector<RegularBooking> UserAllBookings(int id) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException{
    Vector<RegularBooking> send = new Vector<>(); 
    for (RegularBooking aa : this.allBookings()){
             
            if (id == aa.getCostomer().getId()){
             send.add(aa);
            
            }
    }               
           
    return send;
    
 
 }
     
       //ABSTRACT METHODS DEFINED IN THE SUBCLASSES
    public abstract boolean check()throws FileNotFoundException, IOException, ClassNotFoundException, ParseException;
    public abstract double calculateTotalRent();
    public abstract void PayAccount() throws ClassNotFoundException,IOException;
    public abstract void UnPayAccount()throws ClassNotFoundException,IOException;
}