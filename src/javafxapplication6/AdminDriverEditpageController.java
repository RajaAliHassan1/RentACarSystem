/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class AdminDriverEditpageController implements Initializable {
    @FXML
    private TableView<Driver> DriverTable;
    @FXML
    private TableColumn<Integer, Driver> ID;
    @FXML
    private TableColumn<String, Driver> name;
    @FXML
    private TableColumn<Status,Driver> CurrentStatus;
    @FXML
    private TableColumn<String, Driver> cnic;
    @FXML
    private TextField IDEntered;
    @FXML
    private Button RemoveDB;
    @FXML
    private Button AddDriverB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      ID.setCellValueFactory(new PropertyValueFactory<> ("id"));
      name.setCellValueFactory(new PropertyValueFactory<> ("name"));
      CurrentStatus.setCellValueFactory(new PropertyValueFactory<> ("Availibility"));
      cnic.setCellValueFactory(new PropertyValueFactory<> ("cnic"));
       try {
            DriverTable.setItems(getList());
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");
            
        } catch (ClassNotFoundException ex) {
        
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");}
    }    

    public ObservableList<Driver> getList() throws IOException, ClassNotFoundException{
    ObservableList<Driver>Plist = FXCollections.observableArrayList();
    Driver objj = new Driver();
       
      for (Driver aa : objj.AllDrivers()){
      
          Plist.add(aa);
      }
    return Plist;
    
    }
    @FXML
    private void removeDriver(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
    int id = Integer.parseInt(IDEntered.getText());
       Driver o = new Driver ();
       boolean ch= false;
       for (Driver aa: o.AllDrivers()){
       
       
       if(aa.getId()==id){
       
       ch = true;
       }}
       if (ch){
        
       Driver oo = new Driver ();
         
       oo= oo.searchDriver(id);
       
       
        
       oo.delDriver();
       
        JOptionPane.showMessageDialog(null, "Driver Deleted");
        Parent root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) RemoveDB.getScene().getWindow();
        stage1.close();
    
    
            
       
       }
       else{
       
           JOptionPane.showMessageDialog(null, "Enter the Correct ID from the Table Given");
       
       }
           
    
    
    
    
    }

    @FXML
    private void AddDriverAction(ActionEvent event) throws IOException {
    
    
    Parent root = FXMLLoader.load(getClass().getResource("AdminDriverAdd.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) AddDriverB.getScene().getWindow();
        stage1.close();
    
    
    
    }
    
}
