/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import inventorymanagement.Part;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class AddPartController implements Initializable {

    @FXML private Label mainScreenLabel;
    @FXML private ToggleGroup addtoggle;
    @FXML private Button addpartsave;
    @FXML private Button addpartcancel;
    @FXML private Label addpartchoicelabel;
    @FXML private RadioButton addpartinhouse;
    @FXML private RadioButton addpartoutsourced;
    @FXML private TextField addpartId;
    @FXML private TextField addpartName;
    @FXML private TextField addpartInv;
    @FXML private TextField addpartPrice;
    @FXML private TextField addpartMax;
    @FXML private TextField addpartMin;
    @FXML private TextField addpartCName;
    
    @FXML
    private void addpartradioswitch(ActionEvent event){
        if(addpartinhouse.isSelected()){
            addpartchoicelabel.setText("Top Kek");
        }
        if(addpartoutsourced.isSelected()) {
            addpartchoicelabel.setText("Lul");
        }
    }
    
    @FXML
    private void addpart(Event event) throws IOException{
        Part tempPart = new Part(Integer.parseInt(addpartId.getText()),
            addpartName.getText(),
            Double.parseDouble(addpartPrice.getText()),
            Integer.parseInt(addpartInv.getText()),
            Integer.parseInt(addpartMin.getText()),
            Integer.parseInt(addpartMax.getText()));
        MainScreenController.data.add(tempPart);
        Stage stage = (Stage) addpartsave.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void addpartCancel() throws IOException{
        Stage stage = (Stage) addpartcancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }
}