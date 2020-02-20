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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Raja Ali Hassan
 */
public class AdminAddCarController implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField platenum;
    @FXML
    private TextField rentperhour;
    @FXML
    private TextField rentperday;
    @FXML
    private Button addButton;
    @FXML
    private Button cancelAction;
    @FXML
    private RadioButton midrad;
    @FXML
    private RadioButton ecoRad;
    @FXML
    private RadioButton luxury;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddAction(ActionEvent event) {
        
        
        String nam = name.getText();
        String plate = platenum.getText();
        double renthour = Double.parseDouble(rentperhour.getText());
        double rentday = Double.parseDouble(rentperday.getText());
        
        CarType ac = null;
        if(midrad.isSelected()){
          ac = CarType.MIDDLE;
        }
        if(ecoRad.isSelected()){
          ac = CarType.ECONOMY;
        }
        if(luxury.isSelected()){
        
          ac = CarType.LUXURY;
        }
        
  //String carName, String plateNum, CarType ecoType,
        //Status availibility, int costomerId, double rentperHour, double rentPerDay      
        try {
        Car obj = new Car(nam,plate,ac,Status.AVAILABLE,0,renthour,rentday);
        obj.addCar(obj);
        JOptionPane.showMessageDialog(null, "Car Added");
        
        name.clear();;
        platenum.clear();
        rentperhour.clear();
        rentperday.clear();
        }
        catch(Exception ee){ JOptionPane.showMessageDialog(null, "UnHandled Exception Caught");      }
        
        
    }

    @FXML
    private void CancelAction(ActionEvent event) {
    
     Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminManageCarMenu.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) cancelAction.getScene().getWindow();
        stage1.close();
    
    
    }
    
}
