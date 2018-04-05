/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import inventorymanagement.Inventory;
import static inventorymanagement.Inventory.getProducts;
import static inventorymanagement.MainScreenController.getTempPartIndex;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */

static Product tempProduct;

public class EditProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempProduct = MainScreenController.productData.get(MainScreenController.getTempPartIndex());
        System.out.println(tempPart.getName() + " " + tempPart.getPartID());
        editpartId.setText(String.valueOf(tempPart.getPartID()));
        editpartName.setText(tempPart.getName());
        editpartInv.setText(Integer.toString(tempPart.getInStock()));
        editpartPrice.setText(Double.toString(tempPart.getPrice()));
        editpartMax.setText(Integer.toString(tempPart.getMax()));
        editpartMin.setText(Integer.toString(tempPart.getMin()));
    }    
    
}
