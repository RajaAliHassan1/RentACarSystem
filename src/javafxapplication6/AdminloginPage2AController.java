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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ali Hassan
 */
public class AdminloginPage2AController implements Initializable {
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Button CancelButton;
    @FXML
    private Button signinButton;

    /**
     * Initializes the controller class.
     *///DONE
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CancelAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginchoospage 1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) CancelButton.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void SigninAction(ActionEvent event) {

        
        FileReader file;
        Scanner in;
        try {
            
        file= new FileReader ("adminsData.txt");
        in = new Scanner(file);
        String data = in.nextLine();
        String[] arr= data.split("-");

        if(userName.getText().equals(arr[0]) && password.getText().equals(arr[1]) ){
          //CHANGE FXML FILE NAME
          Parent root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
          Scene scene = new Scene(root);
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.show();
          
          Stage stage1 = (Stage) signinButton.getScene().getWindow();
          stage1.close();
      }
       else {
          JOptionPane.showMessageDialog(null, "User Not Found");
      }
      
        
        
        
        }
        catch(Exception ee){
        
        JOptionPane.showMessageDialog(null, "UnHandled Exception Cought");
        }
        
        
        
        
        
    }
    
}
