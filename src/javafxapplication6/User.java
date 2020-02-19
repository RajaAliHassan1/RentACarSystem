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
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
public class User implements Serializable {
    
    //Attributes
    private int id;
    private String Name;
    private String cnic;
    private String mobileNum;
    private String userName;
    private String password;
    private String adress;
    private myDate registrationDate;
    private myDate lastUpdateDate;
    
     
    //Constructors 

    public User() {
        
    }

    public User(String Name, String cnic, String mobileNum, String userName, String password, String adress) {
        Random random = new Random();
        this.id= random.nextInt(1000);
        this.Name = Name;
        this.cnic = cnic;
        this.mobileNum = mobileNum;
        this.userName = userName;
        this.password = password;
        this.adress = adress;
        myDate s = new myDate(); s.setDay(0); s.setMonth(0); s.setYear(0);
        this.registrationDate = new myDate();
        this.lastUpdateDate = s;
    }

    
    //Setter Methods 

    public void setRegistrationDate(myDate registrationDate) {
        this.registrationDate = registrationDate;
        
    }

    public void setLastUpdateDate(myDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    //Getter Methods 

    public myDate getRegistrationDate() {
        return registrationDate;
    }

    public myDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAdress() {
        return adress;
    }
    
    //Method to Add a New User in the System
    public void addUser (User obj) throws FileNotFoundException, IOException, ClassNotFoundException{
    
        File f = new File("Users.bin");
        Vector<String> read = new Vector<>();
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Users.bin");
        in = new Scanner(file);

        while (in.hasNext()) {

            read.add(in.nextLine());
        
        }

        in.close();
        file.close();
        f.delete();
        f.createNewFile();

        String ad;
  ad = obj.getId()+"="+obj.getUserName()+"="+obj.getName()+"="+obj.getCnic()+"="+obj.getMobileNum()+"="+obj.getPassword()+"="+obj.getAdress()+"="+obj.getRegistrationDate()+"="+obj.getLastUpdateDate();
        read.add(ad);
 
        PrintWriter out = new PrintWriter("Users.bin");
        int i = 0;

        while (i < read.size()) {
        
            out.println(read.get(i));
            i++;

        }
        out.close();

    
    }
    
    //Method to delUser from the System.
    public void delUser(int id) throws FileNotFoundException, IOException, ClassNotFoundException{
    
        int re = 0;
        File f = new File("Users.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Users.bin");
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
            if (Integer.parseInt(data[0]) == id) {

                re = i;

            }
            data = null;
            i++;
        }
        read.remove(re);

        PrintWriter out = new PrintWriter("Users.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

         
    }
          
    //Method to update  User Info 
    public void updateUser() throws FileNotFoundException, IOException, ClassNotFoundException{
     
        int re = 0;
        File f = new File("Users.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Users.bin");
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
        //ad = obj.getId()+" "+obj.getUserName()+" "+obj.getName()+" "+obj.getCnic()+" "+obj.getMobileNum()+" "+obj.getPassword()+" "+obj.getAdress()+" "+obj.getRegistrationDate()+" "+obj.getLastUpdateDate();
        
    add  = this.getId()+"="+this.getUserName()+"="+this.getName()+"="+this.getCnic()+"="+this.getMobileNum()+"="+this.getPassword()+"="+this.getAdress()+"="+this.getRegistrationDate()+"="+this.getLastUpdateDate();
           
        read.add(add);

        PrintWriter out = new PrintWriter("Users.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

        
       
    }
    public Vector<User> allUser() throws FileNotFoundException, IOException, ClassNotFoundException{
        
       File f = new File("Users.bin");
        Vector<String> read = new Vector<>();
        Vector<User> send = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Users.bin");
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
        if(read == null){return null;}
        for (String aa : read) {
      String [] ac = aa.split("=");
    int id = Integer.parseInt(ac[0]);
    String Name = ac[2];
    String cnic = ac[3];
    String mobileNum = ac[4];
    String userName = ac[1];
    String password = ac[5];
    String adress = ac[6];
    myDate rd = new myDate(ac[7]);
    myDate registrationDate = rd;
    myDate ld = new myDate(ac[8]);
    myDate lastUpdateDate = ld;
            
            User obj = new User();
            obj.setId(id);obj.setAdress(adress);obj.setCnic(cnic); obj.setMobileNum(mobileNum); obj.setLastUpdateDate(lastUpdateDate);
            obj.setName(Name); obj.setPassword(password); obj.setUserName(userName); obj.setRegistrationDate(registrationDate);
            
            
       send.add(obj);
        
 
        }

        return send;

   }

   
    
    //Method to Search a User by Cnic,Name and ID.
     //Returns a User Type Object 
    public User searchUser(int id ) throws IOException, ClassNotFoundException{
    
      File f = new File("Users.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Users.bin");
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
            if (Integer.parseInt(data[0]) == id) {
                ser = aa;   
      

            }
            data = null;
            i++;
        }
        
        if(ser == null){
        return null;
        }
        
    String ac[]= ser.split("=");
    int idd = Integer.parseInt(ac[0]);
    String Name = ac[2];
    String cnic = ac[3];
    String mobileNum = ac[4];
    String userName = ac[1];
    String password = ac[5];
    String adress = ac[6];
    myDate rd = new myDate(ac[7]);
    myDate registrationDate = rd;
    myDate ld = new myDate(ac[8]);
    myDate lastUpdateDate = ld;
            
            User obj = new User();
            obj.setId(idd);obj.setAdress(adress);obj.setCnic(cnic); obj.setMobileNum(mobileNum); obj.setLastUpdateDate(lastUpdateDate);
            obj.setName(Name); obj.setPassword(password); obj.setUserName(userName); obj.setRegistrationDate(registrationDate);
            
     return obj;
      
  
    }
    public int checkLogin(String userName , String Password ) throws FileNotFoundException, IOException{
        
      File f = new File("Users.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Users.bin");
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
        j=0;
        for (String aa : read) {
    
            data = aa.split("=");
            if (data[1].equals(userName) && data[5].equals(Password)) {
                ser = aa;   
              j = Integer.parseInt(data[0]);
            }
            data = null;
            i++;
        }
        
        return j;    
       
        
   }
    
    
    
    
    
    
    
    
    
    }
    
    
    
    

