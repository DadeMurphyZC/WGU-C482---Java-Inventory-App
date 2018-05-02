/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import inventorymanagement.Parser;

/**
 *
 * @author cfonseca
 */
public class Validator {
    
    public static boolean isInt(TextField input) {
        try {
            Integer.parseInt(input.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean maxInv(TextField addpartInv, TextField addpartMax, TextField addpartMin){
        if(Parser.parseInt(addpartInv)>=Parser.parseInt(addpartMin)&&
           Parser.parseInt(addpartInv)<=Parser.parseInt(addpartMax)){
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isminmaxValid(TextField min, TextField max) {
        return Integer.parseInt(min.getText()) <= Integer.parseInt(max.getText());
    }

    public static void showAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
