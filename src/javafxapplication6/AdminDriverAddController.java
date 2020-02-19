/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dawar Mustaqeem
 */
public class AdminDriverAddController implements Initializable {
    @FXML
    private TextField nam;
    @FXML
    private TextField mobileNum;
    @FXML
    private TextField cnic;
    @FXML
    private Button addButton;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddDriver(ActionEvent event) {
    //String name, String MobileNumber, Status Availibility,
        //myDate bookStartDate, myDate bookEndDate, int carIdDutyOn,String cnic    
        myDate oo = new myDate("0-0-0");
     try {
        Driver o = new Driver(nam.getText(),mobileNum.getText(),Status.AVAILABLE,oo,oo,0,cnic.getText());
        o.addDriver(o);
        JOptionPane.showMessageDialog(null, "Driver Added");
     }
     catch (Exception ee){}
        
        
    }

    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("AdminDriverEditpage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) cancel.getScene().getWindow();
        stage1.close();
    }
    
}
