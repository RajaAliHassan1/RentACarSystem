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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ali Hassan
 */
public class Loginchoospage1Controller implements Initializable {
    @FXML
    private Button UserType;
    @FXML
    private Button AdminLoginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UserTypeAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Userlogin page 2U.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Welcome To RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) UserType.getScene().getWindow();
        stage1.close();

    }

    @FXML
    private void AdminLogin(ActionEvent event) throws IOException {
    
        Parent root = FXMLLoader.load(getClass().getResource("adminloginPage 2A.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Welcome To RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) AdminLoginButton.getScene().getWindow();
        stage1.close();
    
    }
    
}
