/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ali Hassan
 */

//Make Metod to throw value ID
public class UserloginPage2UController implements Initializable {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button SignUpButton;
    @FXML
    private Button LoginButton;
    private int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    

    @FXML
    private void SignUpAction(ActionEvent event) throws IOException {
    
       Parent root = FXMLLoader.load(getClass().getResource("sign up.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) SignUpButton.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void LoginAction(ActionEvent event) {
        
        User s = new User();
        int ch = 0;
        try {
            
        ch = s.checkLogin(userName.getText(), password.getText());
        
         if(ch==0){
         
         throw new NullPointerException();
         }
        File f = new File("id.txt");
        f.delete();
        f.createNewFile();
        PrintWriter out = new PrintWriter("id.txt");
        out.println(ch);
        out.close();
        s = s.searchUser(ch);
        }
        catch(NullPointerException ee){}
        catch(Exception ee){
        JOptionPane.showMessageDialog(null, ee.getMessage());}
    
        
    
        
        if (ch == 0){
            JOptionPane.showMessageDialog(null,"User Not Found");}
           
        else{

            try {
                Parent root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("RentACar System");
                stage.setScene(scene);
                stage.show();
                
                Stage stage1 = (Stage) LoginButton.getScene().getWindow();
                stage1.close();
            }
            catch (IOException ee){
                
                
            }
        }
        }
    }