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
    public static SceneSwitch editScene = new SceneSwitch();
    
    @FXML
    private void editpartradioswitch(ActionEvent event){
        if(editpartinhouse.isSelected()){
            editpartchoicelabel.setText("Machine ID");
        }
        if(editpartoutsourced.isSelected()) {
            editpartchoicelabel.setText("Company Name");
        }
    }
    
    @FXML
    private void editpart(Event event) throws IOException{
        if(Validator.isminmaxValid(editpartMin, editpartMax)&&
           Validator.maxInv(editpartInv, editpartMax, editpartMin))
        {   if(MainScreenController.data.contains(tempPart)) {
            tempPart = new Part(Integer.parseInt(editpartId.getText()),
                                editpartName.getText(),
                                Double.parseDouble(editpartPrice.getText()),
                                Integer.parseInt(editpartInv.getText()),
                                Integer.parseInt(editpartMin.getText()),
                                Integer.parseInt(editpartMax.getText()));
            MainScreenController.data.set(MainScreenController.getTempPartIndex(), tempPart);
            editScene.setButton(editpartsave);
            editScene.setFile("MainScreen.fxml");
            editScene.sceneSwitch();
            }
        } else {
            Validator.showAlert("\nPlease check the following: "
                    + "\n\nMIN value cannot be greater than MAX value."
                    + "\nInv value must be between MIN and MAX values.");
        }
    }
    
    @FXML
    private void editpartCancel() throws IOException{
        if(Confirm.cancel()==true){
            editScene.setButton(editpartcancel);
            editScene.setFile("MainScreen.fxml");
            editScene.sceneSwitch();
        }
    }
    
    @FXML
    private void deletepart(Event event) throws IOException{
        if(Confirm.delete()==true){
            if(MainScreenController.data.contains(tempPart)){
                MainScreenController.data.remove(tempPart);
            }
            editScene.setButton(editpartsave);
            editScene.setFile("MainScreen.fxml");
            editScene.sceneSwitch();
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempPart = MainScreenController.data.get(MainScreenController.getTempPartIndex());
        editpartId.setDisable(true);
        editpartId.setText(String.valueOf(tempPart.getPartID()));
        editpartName.setText(tempPart.getName());
        editpartInv.setText(Integer.toString(tempPart.getInStock()));
        editpartPrice.setText(Double.toString(tempPart.getPrice()));
        editpartMax.setText(Integer.toString(tempPart.getMax()));
        editpartMin.setText(Integer.toString(tempPart.getMin()));  
    }    
    
}