/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javafx.scene.control.TextField;

/**
 *
 * @author cfonseca
 */
public class Parser {
    
    public static int parseInt(TextField field){
        int tempint = Integer.parseInt(field.getText());
        return tempint;
    }
    
    public static Double parseDouble(TextField field) {
        Double tempstr = Double.parseDouble(field.getText());
        return tempstr;
    }
    
}
