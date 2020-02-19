/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AdminBookingPanalController implements Initializable {
    @FXML
    private TableView<RegularBooking> AllBookingTable;
    @FXML
    private TableColumn<Integer, RegularBooking> id;
    @FXML
    private TableColumn<Car, RegularBooking> carName;
    @FXML
    private TableColumn<Car, RegularBooking> costomerName;
    @FXML
    private TableColumn<Integer, RegularBooking> RESERFOR;
    @FXML
    private TableColumn<String, RegularBooking> BookingDate;
    @FXML
    private TextField selectedID;
    @FXML
    private Button DeleteBookingB;
    @FXML
    private Button doenB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      id.setCellValueFactory(new PropertyValueFactory<> ("id"));
      carName.setCellValueFactory(new PropertyValueFactory<> ("carName"));
      costomerName.setCellValueFactory(new PropertyValueFactory<> ("Name"));
      RESERFOR.setCellValueFactory(new PropertyValueFactory<> ("daysReserve"));
      BookingDate.setCellValueFactory(new PropertyValueFactory<> ("bill"));
        try {
            AllBookingTable.setItems(getList());
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");
            
        } catch (ClassNotFoundException ex) {
        
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");}  
        catch (ParseException ex) {
            Logger.getLogger(RemoveBookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }    

    
    
    
    
     public ObservableList<RegularBooking> getList() throws IOException, ClassNotFoundException, FileNotFoundException, ParseException{
    ObservableList<RegularBooking>Plist = FXCollections.observableArrayList();
    RegularBooking objj = new RegularBooking();
    Car car = new Car();  
    for (RegularBooking aa : objj.allBookings()){
    
         Plist.add(aa);
         
      }
    
      return Plist;
    
    }
    
    
    @FXML
    private void DeleteBookingAction(ActionEvent event) {
    
    int a = Integer.parseInt(selectedID.getText());
        
        try {
    RegularBooking o = new RegularBooking();
    o=o.searchBooking(a);
    o.deleteBooking();
    JOptionPane.showMessageDialog(null, "Booking Deleted Successfully2"); 
    }
    catch(Exception E){}
    
    
    }

    @FXML
    private void DoneAction(ActionEvent event) {
        
           Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) doenB.getScene().getWindow();
        stage1.close();
     
    }
    
}
