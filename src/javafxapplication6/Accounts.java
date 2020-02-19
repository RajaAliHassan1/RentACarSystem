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
import java.text.SimpleDateFormat;
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
import java.util.Vector;
import java.lang.instrument.Instrumentation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Accounts implements Serializable {

    //Attributes
    private String holderName;
    private int id;
    private int userId;
    private double balance;
    private double credit;
    private myDate lastTransActionDate;
    private myDate RegistrationDate;
    static int count;
    //Constructor
    public Accounts() {

    }

    public Accounts(String holderName, double balance, double credit, int userId) {
        
        Random random = new Random();
        this.id= random.nextInt(1000);
        this.holderName = holderName;
        this.balance = balance;
        this.credit = credit;
        myDate set1 = new myDate(); set1.setDay(0); set1.setMonth(0); set1.setYear(0);
        this.lastTransActionDate = set1;
        this.userId = userId;
        myDate set = new myDate();
        this.RegistrationDate = set;

    }

    //Getter Methods
    public String getHolderName() {
        return holderName;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getCredit() {
        return credit;
    }

    public myDate getLastTransActionDate() {
        return lastTransActionDate;
    }

    public myDate getRegistrationDate() {
        return RegistrationDate;
    }

    public int getUserId() {
        return userId;
    }

    //Setter Methos 
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setLastTransActionDate(myDate lastTransActionDate) {
        this.lastTransActionDate = lastTransActionDate;
    }

    public void setRegistrationDate(myDate RegistrationDate) {
        this.RegistrationDate = RegistrationDate;
    }

    //Method to Add Record  //Done
    public void addAccount(Accounts obj) throws IOException, ClassNotFoundException {

        
        File f = new File("Accounts.bin");
        Vector<String> read = new Vector<>();
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Accounts.bin");
        in = new Scanner(file);

        while (in.hasNext()) {

            read.add(in.nextLine());
        
        }

        in.close();
        file.close();
        f.delete();
        f.createNewFile();

        String ad;


 ad = obj.getId() + "=" + obj.getHolderName() +
 "=" + obj.getUserId() + "=" + obj.getBalance() +
 "=" + obj.getCredit() + "=" + obj.getRegistrationDate() + "=" + obj.getLastTransActionDate();
        
 
        read.add(ad);
 
        PrintWriter out = new PrintWriter("Accounts.bin");
        int i = 0;

        while (i < read.size()) {
        
            out.println(read.get(i));
            i++;

        }
        out.close();

    }

    //Updating a Record 
    public void upDateAccount() throws IOException, ClassNotFoundException {

        myDate update = new myDate();
        this.lastTransActionDate = update;
        int re = 0;
        File f = new File("Accounts.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Accounts.bin");
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

        add = this.getId()+"="+this.getHolderName()+"="+this.getUserId()+"="+this.getBalance()+"="+this.getCredit()+"="+this.getRegistrationDate()+"="+this.getLastTransActionDate();
        read.add(add);

        PrintWriter out = new PrintWriter("Accounts.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

    }

    //Method to DelRecord //userID
    public void delAccount(int id) throws FileNotFoundException, IOException, ClassNotFoundException {

        int re = 0;
        File f = new File("Accounts.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Accounts.bin");
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
            if (Integer.parseInt(data[2]) == id) {

                re = i;

            }
            data = null;
            i++;
        }
        read.remove(re);

        PrintWriter out = new PrintWriter("Accounts.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

    }

    //METHOD TO DEL BOOKING //SEARCH WITH BOOKID
     
    public void delAccountBookID(int id) throws FileNotFoundException, IOException, ClassNotFoundException {

        int re = 0;
        File f = new File("Accounts.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Accounts.bin");
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

        PrintWriter out = new PrintWriter("Accounts.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

    }

    
    
    
    //Method for Searching  The Account //UserID
    public Accounts searchAccount(int id) throws FileNotFoundException, IOException, ParseException {
   
        int re = 0;
        File f = new File("Accounts.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Accounts.bin");
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
   
            if (Integer.parseInt(data[2]) == id) {
   
                ser = aa;   //SAVING STRING TO BE DELETED
                re = i;

            }
            data = null;
            i++;
        }
   
        String[] ac = ser.split("=");
   
        int idd = Integer.parseInt(ac[0]);
   
        String holderName = ac[1];
   
        int userId = Integer.parseInt(ac[2]);
   
        double balance = Double.parseDouble(ac[3]);
   
        double credit = Double.parseDouble(ac[4]);
   
        myDate lt = new myDate(ac[6]);
   
        myDate lastTransActionDate = lt;
   
        myDate rd = new myDate(ac[6]);
   
        myDate RegistrationDate = rd;
   
        Accounts send = new Accounts();
        send.setBalance(balance);
        send.setCredit(credit);
        send.setHolderName(holderName);
        send.setId(idd);
        send.setLastTransActionDate(lastTransActionDate);
        send.setRegistrationDate(RegistrationDate);
        send.setUserId(userId);

        return send;

    }

    //Method Whick Returns All The Accounts In the System As ArrayList
    public Vector<Accounts> AllAccounts() throws FileNotFoundException, IOException, ClassNotFoundException, ParseException {
 
        File f = new File("Accounts.bin");
        Vector<String> read = new Vector<>();
        Vector<Accounts> send = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Accounts.bin");
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
              String[] ac = aa.split("=");
            int idd = Integer.parseInt(ac[0]);
            String holderName = ac[1];
            int userId = Integer.parseInt(ac[2]);
            double balance = Double.parseDouble(ac[3]);
            double credit = Double.parseDouble(ac[4]);
            myDate lt = new myDate(ac[6]);
            myDate lastTransActionDate = lt;
            myDate rd = new myDate(ac[5]);
            myDate RegistrationDate = rd;
  
            Accounts obj = null;
            obj = new Accounts();
            obj.setBalance(balance);
            obj.setCredit(credit);
            obj.setHolderName(holderName);
            obj.setId(idd);
            obj.setLastTransActionDate(lastTransActionDate);
            obj.setRegistrationDate(RegistrationDate);
            obj.setUserId(userId);
  
            send.add(obj);
 
        }

        return send;

    }
    //Method for Searching  The Account //BOOKID
    public Accounts searchbyBookID(int id) throws FileNotFoundException, IOException, ParseException {

        
        int re = 0;
        File f = new File("Accounts.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Accounts.bin");
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
                ser = aa;   //SAVING STRING TO BE DELETED
                re = i;

            }
            data = null;
            i++;
        }

        String[] ac = ser.split("=");
        int idd = Integer.parseInt(ac[0]);
        String holderName = ac[1];
        int userId = Integer.parseInt(ac[2]);
        double balance = Double.parseDouble(ac[3]);
        double credit = Double.parseDouble(ac[4]);
        myDate lt = new myDate(ac[6]);
        myDate lastTransActionDate = lt;
        myDate rd = new myDate(ac[6]);
        myDate RegistrationDate = rd;

        Accounts send = new Accounts();
        send.setBalance(balance);
        send.setCredit(credit);
        send.setHolderName(holderName);
        send.setId(idd);
        send.setLastTransActionDate(lastTransActionDate);
        send.setRegistrationDate(RegistrationDate);
        send.setUserId(userId);

        return send;

    }

}
