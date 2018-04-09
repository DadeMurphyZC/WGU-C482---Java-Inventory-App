/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author cfonseca
 */
public class Confirm {
    
    public static boolean delete(){
        Boolean choice;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Please confirm:");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this part?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            choice = true;
        } else {
            choice = false;
        }
        return choice;
    }
    
    public static boolean cancel() {
        Boolean cancelChoice;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Please confirm:");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to cancel and go back?");
        Optional<ButtonType> cancelResult = alert.showAndWait();
        if(cancelResult.get() == ButtonType.OK) {
            cancelChoice = true;
        } else {
            cancelChoice = false;
        }
        return cancelChoice;
    }
    
}
