/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author cfonseca
 */
public class SceneSwitch {
    
    Button button;
    String file;
    
    SceneSwitch(Button button, String file){
        this.button = button;
        this.file = file;
    }
    
    public void sceneSwitch() throws IOException{
        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(file));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
