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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ali Hassan
 */
public class SignUpController implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField cnic;
    @FXML
    private TextField mobile;
    @FXML
    private TextField adress;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button SignUpButton;
    @FXML
    private Button CancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignUpAction(ActionEvent event) {
        
        User obj = new User(name.getText(),cnic.getText(),mobile.getText(),username.getText(),password.getText(),adress.getText());
        Accounts ob = new Accounts(name.getText(),0,0,obj.getId());        
        try 
        {
            obj.addUser(obj);
            ob.addAccount(ob);
        Parent root = FXMLLoader.load(getClass().getResource("Userlogin page 2U.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) SignUpButton.getScene().getWindow();
        stage1.close();
        
        }
        catch (Exception ee){JOptionPane.showMessageDialog(null, "UnHandled Exception Caught");}
        
        
    }

    @FXML
    private void CancelAction(ActionEvent event) throws IOException {
    
        Parent root = FXMLLoader.load(getClass().getResource("Userlogin page 2U.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) CancelButton.getScene().getWindow();
        stage1.close();
    
    }
    
}
