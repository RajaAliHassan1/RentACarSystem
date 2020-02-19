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
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author Ali Hassan
 */
public class Car implements Serializable{
    //Attributes 
    private int id;
    private String carName;
    private String plateNum;
    private CarType ecoType;
    private Status availibility;
    private int costomerId;
    private double rentperHour;
    private double rentPerDay;
    static int count;
    
   
  
   //Constructors 

    public Car() {
    }

    public Car( String carName, String plateNum, CarType ecoType, Status availibility, int costomerId, double rentperHour, double rentPerDay) {
        Random random = new Random();
        this.id= random.nextInt(100);
        this.carName = carName;
        this.plateNum = plateNum;
        this.ecoType = ecoType;
        this.availibility = availibility;
        this.costomerId = costomerId;
        this.rentperHour = rentperHour;
        this.rentPerDay = rentPerDay;
        
    
    }
   
  //Setter Method 

    
    
    public void setEcoType(CarType ecoType) {
        this.ecoType = ecoType;
    }

    public void setRentperHour(double rentperHour) {
        this.rentperHour = rentperHour;
    }
    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public void setStatus(CarType ecoType) {
        this.ecoType = ecoType;
    }

    public void setAvailibility(Status availibility) {
        this.availibility = availibility;
    }

    public void setCostomerId(int costomerId) {
        this.costomerId = costomerId;
    }
    
    //Getter Methods 

    
    public CarType getEcoType() {
        return ecoType;
    }

    public double getRentperHour() {
        return rentperHour;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    
    public int getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public CarType getStatus() {
        return ecoType;
    }

    public Status getAvailibility() {
        return availibility;
    }

    public int getCostomerId() {
        return costomerId;
    }
    
    //Method to Add a Car in the System
    public void addCar(Car obj) throws FileNotFoundException, IOException, ClassNotFoundException{
    
        File f = new File("Cars.bin");
        Vector<String> read = new Vector<>();
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Cars.bin");
        in = new Scanner(file);

        while (in.hasNext()) {

            read.add(in.nextLine());
        
        }

        in.close();
        file.close();
        f.delete();
        f.createNewFile();

        String ad;

//  int id, String carName, String plateNum, CarType ecoType, Status availibility, int costomerId
 //, double rentperHour, double rentPerDay, Status currentState
 ad = obj.getId()+"="+obj.getCarName()+"="+obj.getPlateNum()+"="+obj.getEcoType()+"="+obj.getAvailibility()+"="+obj.getCostomerId()+"="+obj.rentperHour+"="+obj.rentPerDay;
 
 
        read.add(ad);
 
        PrintWriter out = new PrintWriter("Cars.bin");
        int i = 0;

        while (i < read.size()) {
        
            out.println(read.get(i));
            i++;

        }
        out.close();

        
    }
    
    //Method to Delete a Car in the System
    public void delCar() throws FileNotFoundException, IOException, ClassNotFoundException{
              
        int re = 0;
        File f = new File("Cars.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Cars.bin");
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

        PrintWriter out = new PrintWriter("Cars.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

   
        }
    
    //Method to update a Car in the System
    public void updateCar() throws IOException, ClassNotFoundException{
    
        int re = 0;
        File f = new File("Cars.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Cars.bin");
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
     add = this.id+"="+this.carName+"="+this.plateNum+"="+this.ecoType+"="+this.availibility+"="+this.costomerId+"="+this.rentperHour+"="+this.rentPerDay;

        read.add(add);

        PrintWriter out = new PrintWriter("Cars.bin");
        int ii = 0;

        while (ii < (read.size())) {

            out.println(read.get(ii));
            ii++;

        }
        out.close();

         
    }
    //Method to Return All the Cars in the System as ArrayList
    public ArrayList<Car> AllCars() throws FileNotFoundException, IOException, ClassNotFoundException{
      
        File f = new File("Cars.bin");
        Vector<String> read = new Vector<>();
        ArrayList<Car> send = new ArrayList<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Cars.bin");
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
          
              
        int id = Integer.parseInt(ac[0]);
        String carName = ac[1];
        String plateNum = ac[2];
        Status availibility = null;
        CarType ecoType = null;
        if(ac[3].equals("ECONOMY")){
           ecoType = CarType.ECONOMY;
        }
        if(ac[3].equals("LUXURY")){
            ecoType = CarType.LUXURY;
        }
        if(ac[3].equals("MIDDLE")){
            ecoType = CarType.MIDDLE;
        }
        if(ac[4].equals("AVAILABLE")){
           availibility = Status.AVAILABLE;
        }
        
        if(ac[4].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
        int costomerId = Integer.parseInt(ac[5]);
        double rentperHour = Double.parseDouble(ac[6]);
        double rentPerDay = Double.parseDouble(ac[7]);
  
        Car obj = new Car();
         obj.setAvailibility(availibility); obj.setCarName(carName); obj.setCostomerId(costomerId);
         obj.setEcoType(ecoType); obj.setId(id); obj.setPlateNum(plateNum);obj.setRentPerDay(rentPerDay); obj.setRentperHour(rentperHour);
         obj.setStatus(ecoType);
            send.add(obj);
 
        }

        return send;

   }

    //Method to Return All Available Cars in the System
    public ArrayList<Car> allAvailableCars() throws IOException, ClassNotFoundException{
      System.out.println("In Car Method");
        File f = new File("Cars.bin");
        Vector<String> read = new Vector<>();
        ArrayList<Car> send = new ArrayList<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Cars.bin");
        in = new Scanner(file);
        int j = 0; 
        String aac;
        while (in.hasNext()) {
          System.out.println("ReadingS");
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
          
              
        int id = Integer.parseInt(ac[0]);
        String carName = ac[1];
        String plateNum = ac[2];
        CarType ecoType = null;
        if(ac[3].equals("ECONOMY")){
           ecoType = CarType.ECONOMY;
        }
        if(ac[3].equals("LUXURY")){
            ecoType = CarType.LUXURY;
        }
        if(ac[3].equals("MIDDLE")){
            ecoType = CarType.MIDDLE;
        }
           Status availibility = null;
        if(ac[4].equals("AVAILABLE")){
           availibility = Status.AVAILABLE;
        }
        
        if(ac[4].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
        int costomerId = Integer.parseInt(ac[5]);
        double rentperHour = Double.parseDouble(ac[6]);
        double rentPerDay = Double.parseDouble(ac[7]);
  
        Car obj = new Car();
         obj.setAvailibility(availibility); obj.setCarName(carName); obj.setCostomerId(costomerId);
         obj.setEcoType(ecoType); obj.setId(id); obj.setPlateNum(plateNum);obj.setRentPerDay(rentPerDay); obj.setRentperHour(rentperHour);
         obj.setStatus(ecoType);
         if(obj.getAvailibility() == Status.AVAILABLE){
             System.out.println("Available");
            send.add(obj);
         }
 
        }

        return send;
 
       
    }
    //Method to Return All Booked Cars in the System
    public Vector<Car> allBookedCars() throws IOException, ClassNotFoundException{
    
      
        File f = new File("Cars.bin");
        Vector<String> read = new Vector<>();
        Vector<Car> send = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Cars.bin");
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
          
              
        int id = Integer.parseInt(ac[0]);
        String carName = ac[1];
        String plateNum = ac[2];
        if(ac[3].equals("ECONOMY")){
           ecoType = CarType.ECONOMY;
        }
        if(ac[3].equals("LUXURY")){
            ecoType = CarType.LUXURY;
        }
        if(ac[3].equals("MIDDLE")){
            ecoType = CarType.MIDDLE;
        }
           Status availibility = null;
        if(ac[4].equals("AVAILABLE")){
           availibility = Status.AVAILABLE;
        }
        
        if(ac[4].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
        int costomerId = Integer.parseInt(ac[5]);
        double rentperHour = Double.parseDouble(ac[6]);
        double rentPerDay = Double.parseDouble(ac[7]);
  
        Car obj = new Car();
         obj.setAvailibility(availibility); obj.setCarName(carName); obj.setCostomerId(costomerId);
         obj.setEcoType(ecoType); obj.setId(id); obj.setPlateNum(plateNum);obj.setRentPerDay(rentPerDay); obj.setRentperHour(rentperHour);
         obj.setStatus(ecoType);
         if(obj.getAvailibility() == Status.BOOKED){
            send.add(obj);
         }
 
        }

        return send;
 
        
    }
    
    //Method to Search a Car in the System by ID or NumberPlate 
    public Car searchCar(int id) throws IOException, ClassNotFoundException{
    
      
        File f = new File("Cars.bin");
        Vector<String> read = new Vector<>();
        String[] data;
        FileReader file = null;
        Scanner in = null;
        file = new FileReader("Cars.bin");
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
      

            }
            data = null;
            i++;
        }

        if(ser == null){
        
        return null;
        }
        
        String[] ac = ser.split("=");
        int iid = Integer.parseInt(ac[0]);
        String carName = ac[1];
        String plateNum = ac[2];
         CarType ecoType = null;
        if(ac[3].equals("ECONOMY")){
           ecoType = CarType.ECONOMY;
        }
        if(ac[3].equals("LUXURY")){
            ecoType = CarType.LUXURY;
        }
        if(ac[3].equals("MIDDLE")){
            ecoType = CarType.MIDDLE;
        }
           Status availibility = null;
        if(ac[4].equals("AVAILABLE")){
           availibility = Status.AVAILABLE;
        }
        
        if(ac[4].equals("BOOKED")){
           availibility = Status.BOOKED;
        }
        int costomerId = Integer.parseInt(ac[5]);
        double rentperHour = Double.parseDouble(ac[6]);
        double rentPerDay = Double.parseDouble(ac[7]);
  
        Car obj = new Car();
         obj.setAvailibility(availibility); obj.setCarName(carName); obj.setCostomerId(costomerId);
         obj.setEcoType(ecoType); obj.setId(iid); obj.setPlateNum(plateNum);obj.setRentPerDay(rentPerDay); obj.setRentperHour(rentperHour);
         obj.setStatus(ecoType);
            
         return obj;
  }
  
}
    
    
enum Status {

AVAILABLE,BOOKED;
}
 enum CarType{
LUXURY,MIDDLE,ECONOMY;
}
