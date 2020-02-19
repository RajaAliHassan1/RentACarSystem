/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dawar Mustaqeem
 */
public class MenuUserController implements Initializable {
    @FXML
    private AnchorPane MyProfileB;
    @FXML
    private Label userNameDisLA;
    @FXML
    private Button manageAccountB;
    @FXML
    private Button editprofileB;
    @FXML
    private Button bookcarsB;
    @FXML
    private Button LogoutB;
    private Object textField;
    int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        userNameDisLA.setText("");
        // TODO
    }    

    
    
    
    @FXML
    private void ManageAccount(ActionEvent event) {
        
         
          Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AccountMenuUser.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) bookcarsB.getScene().getWindow();
        stage1.close();

    }

    @FXML
    private void EditProfile(ActionEvent event) {

Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("UserEditProfile.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) editprofileB.getScene().getWindow();
        stage1.close();
     
    
    }

    @FXML
    private void BookCars(ActionEvent event) {
    
    
        
            Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("BookCarUser.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) bookcarsB.getScene().getWindow();
        stage1.close();
    

    
    }

    @FXML
    private void LogoutAction(ActionEvent event) {
   
                   
            
          Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("loginchoospage 1.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) bookcarsB.getScene().getWindow();
        stage1.close();
    
    
    
    }
    
}
