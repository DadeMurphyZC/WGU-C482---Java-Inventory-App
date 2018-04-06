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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */



public class EditProductController implements Initializable {

    static Product tempProduct;

@FXML private Button productSearchButton;
    @FXML private TextField productSearchField;
    @FXML private Button productPartAddButton;
    @FXML private Button productPartDeleteButton;
    @FXML private Button productSaveButton;
    @FXML private Button productCancelButton;
    @FXML Label productIDLabel;
    @FXML Label productNameLabel;
    @FXML Label productInvLabel;
    @FXML Label productPriceLabel;
    @FXML Label productMaxLabel;
    @FXML Label productMinLabel;
    @FXML TextField editproductIDField;
    @FXML TextField editproductNameField;
    @FXML TextField editproductInvField;
    @FXML TextField editproductPriceField;
    @FXML TextField editproductMaxField;
    @FXML TextField editproductMinField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempProduct = MainScreenController.productData.get(MainScreenController.getTempPartIndex());
        System.out.println(tempProduct.getName() + " " + tempProduct.getProductID());
        editproductIDField.setText(String.valueOf(tempProduct.getProductID()));
        editproductNameField.setText(tempProduct.getName());
        editproductInvField.setText(Integer.toString(tempProduct.getInStock()));
        editproductPriceField.setText(Double.toString(tempProduct.getPrice()));
        editproductMaxField.setText(Integer.toString(tempProduct.getMax()));
        editproductMinField.setText(Integer.toString(tempProduct.getMin()));
    }    
    
}
