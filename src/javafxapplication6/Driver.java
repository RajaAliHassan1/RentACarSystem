/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Ali Hassan
 */
public class Driver implements Serializable {
    //Attributes 
    private String name;
    private int id;
    private String MobileNumber;
    private Status Availibility;       
    private myDate bookStartDate;
    private myDate bookEndDate;
    private int carIdDutyOn;
    private String cnic;
            
//Constructors 

    public Driver() {
    }

    public Driver(String name, String MobileNumber, Status Availibility, myDate bookStartDate, myDate bookEndDate, int carIdDutyOn,String cnic) {
        this.name = name;
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.MobileNumber = MobileNumber;
        this.Availibility = Availibility;
        myDate set = new myDate();
        this.bookStartDate = bookStartDate;
        this.bookEndDate = bookEndDate;
        this.carIdDutyOn = carIdDutyOn;
        this.cnic = cnic;
    }
   //GETTER METHODS 
    
    public Status getAvailibility() {
        return Availibility;
    }

    public String getCnic() {
        return cnic;
    }

    public myDate getBookStartDate() {
        return bookStartDate;
    }

    public myDate getBookEndDate() {
        return bookEndDate;
    }

    public int getCarIdDutyOn() {    
        return carIdDutyOn;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public Status isAvailibility() {
        return Availibility;
    }
    
    //Setter Methods 

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setBookStartDate(myDate bookStartDate) {
        this.bookStartDate = bookStartDate;
    }

    public void setBookEndDate(myDate bookEndDate) {
        this.bookEndDate = bookEndDate;
    }

    public void setCarIdDutyOn(int carIdDutyOn) {
        this.carIdDutyOn = carIdDutyOn;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public void setAvailibility(Status Availibility) {
        this.Availibility = Availibility;
    }
    
    //Method to Add Driver 
    
   public void addDriver (Driver obj) throws FileNotFoundException, IOException, ClassNotFoundException {
      File f = new File("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
        Vector<String> read = new Vector<>();
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
        in = new Scanner(file);

        while (in.hasNext()) {

            read.add(in.nextLine());
        
        }

        in.close();
        file.close();
        f.delete();
        f.createNewFile();
     String ad;
//String name, int id, String MobileNumber, boolean Lisense, Status Availibility, Date bookStartDate, Date bookEndDate, int carIdDutyOn,String cnic
ad =  obj.getName()+"="+obj.getId()+"="+obj.getMobileNumber()+"="+obj.getAvailibility()+"="+obj.getBookStartDate()+"="+obj.getBookEndDate()+"="+obj.getCarIdDutyOn()+"="+obj.getCnic();
        read.add(ad);
 
        PrintWriter out = new PrintWriter("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
        int i = 0;

        while (i < read.size()) {
        
            out.println(read.get(i));
            i++;

        }
        out.close();
     
   }
   
   //Method to Update A record in a file 
   public void updateDriver() throws FileNotFoundException, IOException, ClassNotFoundException{
   
        int re = 0;
        File f = new File("Drivers.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Drivers.bin");
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
        
add =  this.name+"="+this.id+"="+this.MobileNumber+"="+this.Availibility+"="+this.bookStartDate+"="+this.bookEndDate+"="+this.carIdDutyOn+"="+this.cnic;
          
        read.add(add);

        PrintWriter out = new PrintWriter("Drivers.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

          
   }

   //Method To Delete Driver 
   public void delDriver () throws FileNotFoundException, IOException, ClassNotFoundException{
       
   
        int re = 0;
        File f = new File("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
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
            if (Integer.parseInt(data[1]) == this.id) {

                re = i;

            }
            data = null;
            i++;
        }
        read.remove(re);

        PrintWriter out = new PrintWriter("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

      
      
     }
   
        //Method to Search the Driver by ID and Name
   public Driver searchDriver(int id) throws IOException, ClassNotFoundException{
   
      File f = new File("Drivers.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Drivers.bin");
      
        in = new Scanner(file);
        int j = 0;

        while (in.hasNext()) {
   
            read.add(in.nextLine());
            j++;
        }
        String ser = null;
        in.close();
        file.close();
        int i = 0;
        for (String aa : read) {
   
            data = aa.split("=");
   
            if (Integer.parseInt(data[1]) == id) {
   
                ser = aa;   //SAVING STRING TO BE DELETED
      

            }
            data = null;
            i++;
        }
        
        if(ser == null){
        return null;
        }
        
   
     String[] ac = ser.split("=");
     String name1=ac[0];
     int idd=Integer.parseInt(ac[1]);
     String MobileNumber=ac[2];
     
     Status availibility = null;
        
        if(ac[3].equals("AVAILABLE")){
          availibility = Status.AVAILABLE;
        }
        if(ac[3].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
     
     myDate set = new myDate(ac[4]);
     myDate bookStartDate = set;
     myDate set1 = new myDate(ac[5]);
     myDate bookEndDate = set1;
     int carIdDutyOn = Integer.parseInt(ac[6]);
     String cnic = ac[7];
                
       Driver obj = new Driver ();
    obj.setCnic( cnic);obj.setBookStartDate(bookStartDate);obj.setBookEndDate(bookEndDate); 
     

    obj.setCarIdDutyOn(carIdDutyOn); obj.setName(name1);
    obj.setId(idd); 
    obj.setMobileNumber(MobileNumber); 
    obj.setAvailibility(availibility); 
        
   return obj;
   
   }
       
          //Method Whick Returns All The Drivers In the System As ArrayList
   public ArrayList<Driver> AllDrivers() throws FileNotFoundException, IOException, ClassNotFoundException{
   
       File f = new File("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
        
       Vector<String> read = new Vector<>();
        ArrayList<Driver> send = new ArrayList<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/Drivers.bin");
        in = new Scanner(file);
        int j = 0;
     
        while (in.hasNext()) {
   
            read.add(in.nextLine());
            j++;
        }
        String ser = null;
        in.close();
        file.close();

        int i = 0;
        for (String aa : read) {
      
            
      //add =  this.name+"="+this.id+"="+this.MobileNumber+"="+this.Availibility+
        //"="+this.bookStartDate+"="+this.bookEndDate+"="+this.carIdDutyOn+"="+this.cnic;
          
      String[] ac = aa.split("=");
      String name1=ac[0];
     int idd=Integer.parseInt(ac[1]);
     String MobileNumber=ac[2];
     Status availibility = null;
        
        if(ac[3].equals("AVAILABLE")){
          availibility = Status.AVAILABLE;
        }
        if(ac[3].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
     
     myDate set = new myDate(ac[4]);
     myDate bookStartDate = set;
     myDate set1 = new myDate(ac[5]);
     myDate bookEndDate = set1;
     int carIdDutyOn = Integer.parseInt(ac[6]);
     String cnic = ac[7];
       Driver obj = new Driver ();
    obj.setCnic( cnic);obj.setBookStartDate(bookStartDate);obj.setBookEndDate(bookEndDate); 
       

    obj.setCarIdDutyOn(carIdDutyOn); obj.setName( name1);
    obj.setId(idd); 
    obj.setMobileNumber(MobileNumber); 
    obj.setAvailibility(availibility); 
      send.add(obj);
        
 
        }
       
        return send;

       
   }
   
        //Method Which Returns All the Available Driver As ArrayList
   public Vector<Driver> allAvailableDrivers()throws FileNotFoundException, IOException, ClassNotFoundException{
   
     File f = new File("Drivers.bin");
     boolean c=true;  
        Vector<String> read = new Vector<>();
        Vector<Driver> send = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Drivers.bin");
        in = new Scanner(file);
        int j = 0; 
        String aac;
        while (in.hasNext()) {
          
            aac = in.nextLine();
            read.add(aac);
            j++;
        }
        String ser = null;
        in.close();
        file.close();

        int i = 0;
        for (String aa : read) {
              String[] ac = aa.split("=");
        
      String name1=ac[0];
     int idd=Integer.parseInt(ac[1]);
     String MobileNumber=ac[2];
    
     Status availibility;
        
        if(ac[3].equals("AVAILABLE")){
          availibility = Status.AVAILABLE;
        }
        if(ac[3].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
     
     myDate set = new myDate(ac[4]);
     myDate bookStartDate = set;
     myDate set1 = new myDate(ac[5]);
     myDate bookEndDate = set1;
     int carIdDutyOn = Integer.parseInt(ac[6]);
     String cnic = ac[7];
                
       Driver obj = new Driver ();
    obj.setCnic( cnic);obj.setBookStartDate(bookStartDate);obj.setBookEndDate(bookEndDate); 
     

    obj.setCarIdDutyOn(carIdDutyOn); obj.setName( name);
    obj.setId(idd); 
    obj.setMobileNumber(MobileNumber); 
    obj.setAvailibility(Availibility); 
          
              
       if(obj.getAvailibility() == Status.AVAILABLE){
            send.add(obj);
            c=false;
         }
 
        }
   if(c == false){
        return send;
    }
   else{
       return null;
   }    
   
   }
        //Method to Return All Booked Drivers As ArrayList
      public Vector<Driver> allBookedDrivers()throws FileNotFoundException, IOException, ClassNotFoundException{
   
     File f = new File("Drivers.bin");
     boolean c=true;  
        Vector<String> read = new Vector<>();
        Vector<Driver> send = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Drivers.bin");
        in = new Scanner(file);
        int j = 0; 
        String aac;
        while (in.hasNext()) {
          
            aac = in.nextLine();
            read.add(aac);
            j++;
        }
        String ser = null;
        in.close();
        file.close();

        int i = 0;
        for (String aa : read) {
              String[] ac = aa.split("=");
        
      String name1=ac[0];
     int idd=Integer.parseInt(ac[1]);
     String MobileNumber=ac[2];
     
     Status availibility;
        
        if(ac[3].equals("AVAILABLE")){
          availibility = Status.AVAILABLE;
        }
        if(ac[3].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
     
     myDate set = new myDate(ac[4]);
     myDate bookStartDate = set;
     myDate set1 = new myDate(ac[5]);
     myDate bookEndDate = set1;
     int carIdDutyOn = Integer.parseInt(ac[6]);
     String cnic = ac[7];
                
       Driver obj = new Driver ();
    obj.setCnic( cnic);obj.setBookStartDate(bookStartDate);obj.setBookEndDate(bookEndDate); 
     

    obj.setCarIdDutyOn(carIdDutyOn); obj.setName( name);
    obj.setId(idd); 
    obj.setMobileNumber(MobileNumber); 
    
    obj.setAvailibility(Availibility); 
          
              
       if(obj.getAvailibility() == Status.BOOKED){
            send.add(obj);
            c=false;
         }
 
        }
   if(c == false){
        return send;
    }
   else{
       return null;
   }    
     
   
   }
        //Method to Return a Available Driver 
      public Driver getAvailableDriver() throws FileNotFoundException, IOException, ClassNotFoundException{
     
    
        File f = new File("Drivers.bin");
         boolean c=true;  
        Vector<String> read = new Vector<>();
        Vector<Driver> send = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Drivers.bin");
        in = new Scanner(file);
        int j = 0; 
        String aac;
        while (in.hasNext()) {
          
            aac = in.nextLine();
            read.add(aac);
            j++;
        }
        String ser = null;
        in.close();
        file.close();

       for (String aa : read) {
              String[] ac = aa.split("=");
        
      String name1=ac[0];
     int idd=Integer.parseInt(ac[1]);
     String MobileNumber=ac[2];
    
     Status availibility = null;
        if(ac[3].equals("AVAILABLE")){
          availibility = Status.AVAILABLE;
        }
        if(ac[3].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
     
     myDate set = new myDate(ac[4]);
     myDate bookStartDate = set;
     myDate set1 = new myDate(ac[5]);
     myDate bookEndDate = set1;
     int carIdDutyOn = Integer.parseInt(ac[6]);
     String cnic = ac[7];
                
       Driver obj = new Driver ();
    obj.setCnic( cnic);obj.setBookStartDate(bookStartDate);obj.setBookEndDate(bookEndDate); 
     

    obj.setCarIdDutyOn(carIdDutyOn); obj.setName(name1);
    obj.setId(idd); 
    obj.setMobileNumber(MobileNumber); 
    obj.setAvailibility(availibility); 
        
      if(obj.getAvailibility() == Status.AVAILABLE){
      
          return obj;
      }
      
      }
        return null;
      }


}
      
      
      







