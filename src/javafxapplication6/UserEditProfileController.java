/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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




public class UserEditProfileController implements Initializable {
    @FXML
    private Button ChangeNameButton;
    @FXML
    private Button chcangePassworButton;
    @FXML
    private TextField NewNametxt;
    @FXML
    private TextField oldPassword;
    @FXML
    private PasswordField newPasstxt;
    @FXML
    private Button CancelButton;
    
   int  id; 
    
   
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
    }    

    
    
    
    
    @FXML
    private void ChangeNameAction(ActionEvent event) {
       
        try 
        
        {
            User obj = new User();
            User objj = obj.searchUser(id);
            objj.setName(NewNametxt.getText());
            objj.updateUser();
            JOptionPane.showMessageDialog(null, "NameChanged");
            NewNametxt.clear();
           
        
        }
        catch(Exception ee){JOptionPane.showMessageDialog(null, "UnHandled Exception Caught");}
    }

    @FXML
    private void changePasswordAction(ActionEvent event) {
    
    
        try 
        
        {
            User obj = new User();
            User objj = obj.searchUser(id);
            if(oldPassword.getText().equals(objj.getPassword())){
            objj.setPassword(newPasstxt.getText());
            objj.updateUser();
            oldPassword.clear();
            newPasstxt.clear();
            JOptionPane.showMessageDialog(null, "Password Changed");
            }
            else {
                    JOptionPane.showMessageDialog(null, "Enter The Correct Old Password");
                    
                    }
            
            }
            
        
        catch(Exception ee){JOptionPane.showMessageDialog(null, "UnHandled Exception Caught");}
    }

    
    

    @FXML
    private void CancelAction(ActionEvent event) throws IOException {
    
    Parent root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) CancelButton.getScene().getWindow();
        stage1.close();
    
    }
    
}
