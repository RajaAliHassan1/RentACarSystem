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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dawar Mustaqeem
 */
public class AccountMenuUserController implements Initializable {
    @FXML
    private Label holdername;
    @FXML
    private Label accountID;
    @FXML
    private Label balance;
    @FXML
    private Label Credit;
    @FXML
    private Button DepositB;
    @FXML
    private PasswordField SerialNum;
    @FXML
    private TextField Amount;
    @FXML
    private Button DoneB;
    int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FileReader file;
        Scanner in;
        
            try {
            
       file = new FileReader ("id.txt");
       in = new Scanner(file);
       id = in.nextInt();
       in.close();     
            }
            catch(Exception ee){ 
            
                JOptionPane.showMessageDialog(null, "ID NOT Inialized");
            }
    try {        
    Accounts obj = new Accounts();
    obj = obj.searchAccount(id);
    holdername.setText(obj.getHolderName());
    accountID.setText(Integer.toString(obj.getId()));
    balance.setText(Double.toString(obj.getBalance()));
    Credit.setText(Double.toString(obj.getCredit()));
    
    
    }
    catch(Exception ee){    JOptionPane.showMessageDialog(null, ee.getMessage());
            }
                
    }    

    @FXML
    private void DepositAction(ActionEvent event) {
        
    FileReader file = null;
    Scanner in = null;
    long  amt;
    double c;
    long b=0;
        try {
            
            file= new FileReader("C:/Users/Dawar Mustaqeem/Documents/NetBeansProjects/JavaFXApplication6/BankCode.bin");
            in = new Scanner(file);
            
            
            String ba= in.nextLine();
             in.close();
            file.close();
            if(ba.equals(SerialNum.getText())){
        
        
        String aa=Amount.getText();
        amt = Long.parseLong(aa);
        Accounts obj = new Accounts(); 
        Accounts objj = obj.searchAccount(id);
        
    double credit = 0;
    double balance;
    double rent = amt;
      if( objj.getBalance() == 0  && objj.getCredit() ==0){
          balance = objj.getBalance() + rent; 
          objj.setBalance(balance);
          objj.setCredit(0);
      }
      
      if( objj.getBalance() < rent && objj.getCredit() == 0){
          balance = rent+ objj.getBalance() ;
          objj.setBalance(balance);
          objj.setCredit(0);
      
      }
      
      if(objj.getCredit() >= rent && objj.getBalance() == 0  ){
      credit = objj.getCredit()-rent;
      objj.setBalance(0);
      objj.setCredit(credit);
      
      }
      if(objj.getCredit() < rent && objj.getBalance() == 0 && objj.getCredit()> 0  ){
      
      credit = rent-objj.getCredit();
      objj.setBalance(credit);
      objj.setCredit(0);
      
      }
           
          try { objj.upDateAccount();
          JOptionPane.showMessageDialog(null, "Amount Added In Account Successfully");
          SerialNum.clear();
          Amount.clear();
          }
          catch(Exception ee){JOptionPane.showMessageDialog(null, ee.getMessage());}
           }
           
           
           
           
           
           
            
            else {
            
             JOptionPane.showMessageDialog(null, "InValid Serial Number Entered");
            
            }
        
    }
        catch(NullPointerException ee ){
        JOptionPane.showMessageDialog(null, "Null Exception");
        
        }
        catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ParseException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    
    }
        
    @FXML
    private void DoneAction(ActionEvent event) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) DoneB.getScene().getWindow();
        stage1.close();
    
    }
    
}
