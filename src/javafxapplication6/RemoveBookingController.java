/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

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
public class RemoveBookingController implements Initializable {
    @FXML
    private TableView<RegularBooking> UserBookings;
    @FXML
    private TableColumn<Integer, RegularBooking> BookingID;
    @FXML
    private TableColumn<String,RegularBooking> CarName;
    @FXML
    private TableColumn<Double, RegularBooking> Bill;
    @FXML
    private TableColumn<Integer, RegularBooking> HoursBookedFor;
    @FXML
    private TableColumn<Integer, RegularBooking> DaysBooked;
    @FXML
    private TextField IDtoRemove;
    @FXML
    private Button RemoveButton;
    @FXML
    private Button CancelB;
  int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
        
        try {
        FileReader file = new FileReader ("id.txt");
        Scanner in = new Scanner(file);
        id = in.nextInt();
        in.close();
        }
        catch(Exception ee){}
    
        
      BookingID.setCellValueFactory(new PropertyValueFactory<> ("id"));
      CarName.setCellValueFactory(new PropertyValueFactory<> ("carName"));
      Bill.setCellValueFactory(new PropertyValueFactory<> ("bill"));
      HoursBookedFor.setCellValueFactory(new PropertyValueFactory<> ("hoursReserve"));
      DaysBooked.setCellValueFactory(new PropertyValueFactory<> ("daysReserve"));
        try {
            UserBookings.setItems(getList());
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
    for (RegularBooking aa : objj.UserAllBookings(id)){
    
         Plist.add(aa);
         
      }
    
      return Plist;
    
    }

    @FXML
    private void DelBookingButton(ActionEvent event) {
         
        int re = Integer.parseInt(IDtoRemove.getText());
        
    try {
        
        
       RegularBooking obj = new RegularBooking(); 
       obj = obj.searchBooking(re);
       obj.deleteBooking();
       
       JOptionPane.showMessageDialog(null, "Deleted");
       
       
       
       
       
    }
    catch(NullPointerException ee){JOptionPane.showMessageDialog(null, "NullException Caught");
    }
    catch(Exception ee){JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");
    }
    
    
   
    }

    @FXML
    private void CancelAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("BookCarUser.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) CancelB.getScene().getWindow();
        stage1.close();
    
    }
    
}
