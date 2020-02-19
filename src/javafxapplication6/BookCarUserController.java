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
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dawar Mustaqeem
 */
public class BookCarUserController implements Initializable {
    @FXML
    private TableView<Car> AvailableCarTab;
    @FXML
    private TableColumn<String,Car> CarNameCol;
    @FXML
    private TableColumn<CarType, Car> CarTypeColume;
    @FXML
    private TableColumn<Double, Car> CarRentPerDayCol;
    @FXML
    private TableColumn<Double, Car> CarRentPerHourCOL;
    @FXML
    private TableColumn<Integer,Car> CarIdCol;
    @FXML
    private TextField BookCartxt;
    @FXML
    private Button BookCarB;
    @FXML
    private Button DoneButton;
    @FXML
    private RadioButton DriverRadio;
    @FXML
    private TextField DaysTXT;
    @FXML
    private TextField HOURSTXT;
    @FXML
    private RadioButton DayOrHour;
    @FXML
    private CheckBox ThreeStarBookingCheck;
    @FXML
    private CheckBox fiveStarCheck;
    @FXML
    private CheckBox RegularBookingcheck;
    @FXML
    private Button wantToRemoveButton;
    
    int id ;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
      CarNameCol.setCellValueFactory(new PropertyValueFactory<> ("carName"));
      CarTypeColume.setCellValueFactory(new PropertyValueFactory<> ("ecoType"));
      CarRentPerHourCOL.setCellValueFactory(new PropertyValueFactory<> ("rentperHour"));
      CarRentPerDayCol.setCellValueFactory(new PropertyValueFactory<> ("rentPerDay"));
      CarIdCol.setCellValueFactory(new PropertyValueFactory<> ("id"));
        try {
            AvailableCarTab.setItems(getList());
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");
            
        } catch (ClassNotFoundException ex) {
        
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");}
    
    
    try {
        FileReader file = new FileReader ("id.txt");
        Scanner in = new Scanner(file);
        id = in.nextInt();
        in.close();
        }
        catch(Exception ee){}
    
    }
    
    public ObservableList<Car> getList() throws IOException, ClassNotFoundException{
        
    ObservableList<Car>Plist = FXCollections.observableArrayList();
    
    Car objj = new Car();
      for (Car aa : objj.allAvailableCars()){
          System.out.println(aa.getCarName());
      Plist.add(aa);
      }
    
      return Plist;
    
    }
    
    
    
    
    @FXML
    private void BookCarAction(ActionEvent event) throws IOException, ClassNotFoundException, ParseException {
       boolean DriverCheck = false;
       Driver d = null;
       User ob = null;
       Car objj = null;
       Accounts acc = null;
       int a;
       Car obj = new Car();      boolean check = false;
       try {  
        a   = Integer.parseInt(BookCartxt.getText());
        for (Car aa : obj.allAvailableCars()){
        if(aa.getId() == a){
         check = true;
        }
        
        }
        
        if (!check){
            JOptionPane.showMessageDialog(null, "Kindly Enter The Correct ID from the Table");
            
        }
        if(check){
       FileReader file;
       Scanner in = null;
       int userid;   
       try {
       file = new FileReader ("id.txt");
       in = new Scanner(file);
       userid = in.nextInt();
       ob = new User();
       ob= ob.searchUser(userid);
       objj = new Car();
       objj = objj.searchCar(a);
       acc = new Accounts();
       acc = acc.searchAccount(userid);
       }
       
       catch(Exception ee){JOptionPane.showMessageDialog(null, ee.getMessage());}
       
      int days=  Integer.parseInt(DaysTXT.getText());
      int hours = Integer.parseInt(HOURSTXT.getText());
       if (DriverRadio.isSelected()){
                 
           JOptionPane.showMessageDialog(null, "Sorry The Driver Services Are Cancelled by the Admin");}
      
       
          
           
      if ( ThreeStarBookingCheck.isSelected() && fiveStarCheck.isSelected())
      {
       JOptionPane.showMessageDialog(null, "KindlySelect Only one");
       Platform.exit();  }
            
      if ( ThreeStarBookingCheck.isSelected() && RegularBookingcheck.isSelected())
      {
       JOptionPane.showMessageDialog(null, "KindlySelect Only one");
      Platform.exit();}
      
      if ( RegularBookingcheck.isSelected() && fiveStarCheck.isSelected())
      {
       JOptionPane.showMessageDialog(null, "KindlySelect Only one");
      Platform.exit();}
            
      if (RegularBookingcheck.isSelected()){
                             
      RegularBooking add = new RegularBooking(objj,d,acc,days,hours,DayOrHour.isSelected(),ob,DriverCheck);
      
      add.addBooking(add);
      JOptionPane.showMessageDialog(null, "Car Booked Successfully");
      JOptionPane.showMessageDialog(null, "Your Total Bill : "+add.getBill());
      }
       if (ThreeStarBookingCheck.isSelected()){
        
      ThreeStarBooking add = new  ThreeStarBooking(objj,d,acc,days,hours,DayOrHour.isSelected(),ob,DriverCheck); 
        if (add.check()){
        RegularBooking adgd = new RegularBooking(objj,d,acc,days,hours,DayOrHour.isSelected(),ob,DriverCheck); 
        JOptionPane.showMessageDialog(null, "Car Booked Successfully");
        JOptionPane.showMessageDialog(null, "Your Total Bill : "+add.getBill());
      
        add.addBooking(adgd);
      }
        else{ JOptionPane.showMessageDialog(null, "Sorry You Can not AvailThree ThreeStarPackage");}
       }
        if (fiveStarCheck.isSelected()){
          FiveStarBooking dd; 
          dd = new  FiveStarBooking(objj,d,acc,days,hours,DayOrHour.isSelected(),ob,DriverCheck);
        if (dd.check()){
        RegularBooking adgd = new RegularBooking(objj,d,acc,days,hours,DayOrHour.isSelected(),ob,DriverCheck); 
        JOptionPane.showMessageDialog(null, "Your Total Bill : "+dd.getBill());
        JOptionPane.showMessageDialog(null, "Car Booked Successfully");
        
        adgd.addBooking(adgd);
      }
        else{
        
          JOptionPane.showMessageDialog(null, "Sorry You Can not Avail Three Star Package");
          dd = null;
        }
        }
       
       
       }}
       
        
       catch(ClassNotFoundException ee){
       
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught ClassNotFound");}
       catch(FileNotFoundException eee){
       
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught FileNotFound");}
       catch(IOException ee){
       
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught IOException");}
      
        
       }
        
        
    

    @FXML
    private void DoneButton(ActionEvent event) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) DoneButton.getScene().getWindow();
        stage1.close();
                   
        
        
    }

    @FXML
    private void removeActionShiftFile(ActionEvent event) {
    
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("RemoveBooking.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) wantToRemoveButton.getScene().getWindow();
        stage1.close();
                   
        
    }

    
    
        }
