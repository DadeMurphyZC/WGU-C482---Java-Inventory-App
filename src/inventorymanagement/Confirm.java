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

    public static boolean delete() {
        Boolean choice;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Please confirm:");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this item?");
        Optional<ButtonType> result = alert.showAndWait();
        choice = result.get() == ButtonType.OK;
        return choice;
    }

    public static boolean cancel() {
        Boolean cancelChoice;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Please confirm:");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to cancel and go back?");
        Optional<ButtonType> cancelResult = alert.showAndWait();
        cancelChoice = cancelResult.get() == ButtonType.OK;
        return cancelChoice;
    }

}
