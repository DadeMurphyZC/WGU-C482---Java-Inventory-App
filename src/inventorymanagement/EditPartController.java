/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import inventorymanagement.Inventory;
import static inventorymanagement.Inventory.getAllParts;
import static inventorymanagement.MainScreenController.getTempPartIndex;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class EditPartController implements Initializable {

    
    @FXML private Label mainScreenLabel;
    @FXML private ToggleGroup edittoggle;
    @FXML private Button editpartsave;
    @FXML private Button editpartcancel;
    @FXML private Label editpartchoicelabel;
    @FXML private RadioButton editpartinhouse;
    @FXML private RadioButton editpartoutsourced;
    @FXML private TextField editpartId;
    @FXML private TextField editpartName;
    @FXML private TextField editpartInv;
    @FXML private TextField editpartPrice;
    @FXML private TextField editpartMax;
    @FXML private TextField editpartMin;
    @FXML private TextField editpartCName; 
    
    static Part tempPart;
    
    @FXML
    private void editpartradioswitch(ActionEvent event){
        if(editpartinhouse.isSelected()){
            editpartchoicelabel.setText("Top Kek");
        }
        if(editpartoutsourced.isSelected()) {
            editpartchoicelabel.setText("Lul");
        }
    }
    
    @FXML
    private void editpart(Event event) throws IOException{
        if(MainScreenController.data.contains(tempPart)) {
            tempPart = new Part(Integer.parseInt(editpartId.getText()),
                                editpartName.getText(),
                                Integer.parseInt(editpartInv.getText()), 
                                (int) Double.parseDouble(editpartPrice.getText()),
                                Integer.parseInt(editpartMax.getText()),
                                Integer.parseInt(editpartMin.getText()));
            MainScreenController.data.set(MainScreenController.getTempPartIndex(), tempPart);
            Stage stage = (Stage) editpartsave.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    @FXML
    private void deletepart(Event event) throws IOException{
        if(MainScreenController.data.contains(tempPart)){
            MainScreenController.data.remove(tempPart);
        }
        Stage stage = (Stage) editpartsave.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempPart = MainScreenController.data.get(MainScreenController.getTempPartIndex());
        System.out.println(tempPart.getName() + " " + tempPart.getPartID());
        editpartId.setText(String.valueOf(tempPart.getPartID()));
        editpartName.setText(tempPart.getName());
        editpartInv.setText(Integer.toString(tempPart.getInStock()));
        editpartPrice.setText(Double.toString(tempPart.getPrice()));
        editpartMax.setText(Integer.toString(tempPart.getMax()));
        editpartMin.setText(Integer.toString(tempPart.getMin()));  
    }    
    
}
