/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class AddProductController implements Initializable {

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
    @FXML TextField productIDField;
    @FXML TextField productNameField;
    @FXML TextField productInvField;
    @FXML TextField productPriceField;
    @FXML TextField productMaxField;
    @FXML TextField productMinField;

    @FXML private TableView<Product> productPartsSearchResultsTable;
    @FXML private TableColumn<Product, Integer> productID;
    @FXML private TableColumn<Product, String> productName;
    @FXML private TableColumn<Product, Double> productPrice;
    @FXML private TableColumn<Product, Integer> productInStock;

    @FXML private TableView<Product> productPartsTable;
    @FXML private TableColumn<Product, Integer> productPartID;
    @FXML private TableColumn<Product, String> productPartName;
    @FXML private TableColumn<Product, Double> productPartPrice;
    @FXML private TableColumn<Product, Integer> productPartInStock;

    static ObservableList<Part> productPartsSearchResults = FXCollections.observableArrayList(
//            new Part(1, "test", 3.99, 1,1,1),
//            new Part(2,"test2",4.99,1,1,1)
    );

    static ObservableList<Part> productParts = FXCollections.observableArrayList(
//            new Part(1, "test", 3.99, 1,1,1),
//            new Part(2,"test2",4.99,1,1,1)
    );

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
