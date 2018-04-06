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
import static inventorymanagement.MainScreenController.getTempProductIndex;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */



public class EditProductController implements Initializable {


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
    
    static Product tempProduct;
    
    @FXML
    private void editproduct(Event event) throws IOException{
        if(MainScreenController.productData.contains(tempProduct)) {
            tempProduct = new Product(Integer.parseInt(editproductIDField.getText()),
                                      editproductNameField.getText(),
                                      Double.parseDouble(editproductPriceField.getText()),
                                      Integer.parseInt(editproductInvField.getText()),
                                      Integer.parseInt(editproductMinField.getText()),
                                      Integer.parseInt(editproductMaxField.getText()));
            MainScreenController.productData.add(tempProduct);
            Stage stage = (Stage) productSaveButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    @FXML
    private void addproductCancel() throws IOException{
        Stage stage = (Stage) productCancelButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempProduct = MainScreenController.productData.get(MainScreenController.getTempProductIndex());
        System.out.println(tempProduct.getName() + " " + tempProduct.getProductID());
        editproductIDField.setText(String.valueOf(tempProduct.getProductID()));
        editproductNameField.setText(tempProduct.getName());
        editproductInvField.setText(Integer.toString(tempProduct.getInStock()));
        editproductPriceField.setText(Double.toString(tempProduct.getPrice()));
        editproductMaxField.setText(Integer.toString(tempProduct.getMax()));
        editproductMinField.setText(Integer.toString(tempProduct.getMin()));
    }    
    
}
