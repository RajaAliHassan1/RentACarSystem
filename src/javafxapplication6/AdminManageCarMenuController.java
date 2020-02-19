/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class AdminManageCarMenuController implements Initializable {
    @FXML
    private TableView<Car> AllCarsTable;
    @FXML
    private TableColumn<Integer, Car> Carid;
    @FXML
    private TableColumn<String, Car> CarNam;
    @FXML
    private TableColumn<String, Car> plateNumber;
    @FXML
    private TableColumn<Status, Car> CarCurrentStatus;
    @FXML
    private TableColumn<CarType, Car> CarType;
    @FXML
    private TextField Idtxt;
    @FXML
    private Button AddCarButton;
    @FXML
    private Button DelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      Carid.setCellValueFactory(new PropertyValueFactory<> ("id"));
      CarNam.setCellValueFactory(new PropertyValueFactory<> ("carName"));
      plateNumber.setCellValueFactory(new PropertyValueFactory<> ("plateNum"));
      CarCurrentStatus.setCellValueFactory(new PropertyValueFactory<> ("availibility"));
      CarType.setCellValueFactory(new PropertyValueFactory<> ("ecoType"));
        try {
            AllCarsTable.setItems(getList());
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");
            
        } catch (ClassNotFoundException ex) {
        
          JOptionPane.showMessageDialog(null, "Unhandled Exception Caught");}
    
      
    }    
    
    public ObservableList<Car> getList() throws IOException, ClassNotFoundException{
        
    ObservableList<Car>Plist = FXCollections.observableArrayList();
    
    Car objj = new Car();
      for (Car aa : objj.AllCars()){
          
      Plist.add(aa);
      }
    
      return Plist;
    
    }
    

    @FXML
    private void AddCarAction(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("AdminAddCar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) AddCarButton.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void DelCarAction(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
    
   int id = Integer.parseInt(Idtxt.getText());
   Car ch = new Car();
   boolean c= false;
   for (Car aa: ch.AllCars()){
   
        if ( id ==  aa.getId()){
        
        c = true;
        }
   
   
   }
   if(c){
           Car obj = new Car();
           Car ob = obj.searchCar(id);
           ob.delCar();
         JOptionPane.showMessageDialog(null, "Car Deleted "); 
         Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("RentACar System");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) DelButton.getScene().getWindow();
        stage1.close();
   }
   else{
   
   JOptionPane.showMessageDialog(null, "Enter the Correct ID from the Table Given");
   //Platform.exit();
   
   }
   
    
    
    
    
    }
    
}
