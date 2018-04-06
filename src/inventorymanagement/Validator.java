/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 *
 * @author cfonseca
 */
public class Validator {
    
    public static boolean isInt(TextField input){
        try {
            Integer.parseInt(input.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isminmaxValid(TextField min, TextField max){
        if(Integer.parseInt(min.getText()) > Integer.parseInt(max.getText())){
            return false;
        } else {
            return true;
        }
    }
    
    public static void showAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
