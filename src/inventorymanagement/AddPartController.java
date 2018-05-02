/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.event.Event;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class AddPartController implements Initializable {
    
    static AtomicInteger partCount = new AtomicInteger();
    static final Object addPartLock = new Object();
    
    @FXML
    private Label mainScreenLabel;
    @FXML
    private ToggleGroup addtoggle;
    @FXML
    private Button addpartsave;
    @FXML
    private Button addpartcancel;
    @FXML
    private Label addpartchoicelabel;
    @FXML
    private RadioButton addpartinhouse;
    @FXML
    private RadioButton addpartoutsourced;
    @FXML
    private TextField addpartId;
    @FXML
    private TextField addpartName;
    @FXML
    private TextField addpartInv;
    @FXML
    private TextField addpartPrice;
    @FXML
    private TextField addpartMax;
    @FXML
    private TextField addpartMin;
    @FXML
    private TextField addpartCName;
    
    
    
    @FXML
    private void addpartradioswitch(ActionEvent event) {
        if (addpartinhouse.isSelected()) {
            addpartchoicelabel.setText("Machine ID");
        }
        if (addpartoutsourced.isSelected()) {
            addpartchoicelabel.setText("Company Name");
        }
    }

    @FXML
    private void addpart(Event event) throws IOException {
        synchronized(addPartLock){
        boolean minmaxvalid = Validator.isminmaxValid(addpartMin, addpartMax);
        boolean invvalid = Validator.maxInv(addpartInv, addpartMax, addpartMin);
        if (minmaxvalid == true && invvalid == true ) {
            Part tempPart = new Part(partCount.incrementAndGet(),
                    addpartName.getText(),
                    Double.parseDouble(addpartPrice.getText()),
                    Integer.parseInt(addpartInv.getText()),
                    Integer.parseInt(addpartMin.getText()),
                    Integer.parseInt(addpartMax.getText()));
            MainScreenController.data.add(tempPart);
            SceneSwitch addpartscene = new SceneSwitch(addpartsave, "MainScreen.fxml");
            addpartscene.sceneSwitch();
        } else {
            Validator.showAlert("\nPlease check the following: \n\nMIN value cannot be greater than MAX value."
                    + "\nInv value must be between MIN and MAX values.");
        }}

    }

    @FXML
    private void addpartCancel() throws IOException {
        if(Confirm.cancel()==true){
            SceneSwitch addpartcancelscene = new SceneSwitch(addpartcancel, "MainScreen.fxml");
            addpartcancelscene.sceneSwitch();
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addpartId.setDisable(true);
        addpartId.setText(partCount.get()+1+" (Auto-generated)");
    }
}
