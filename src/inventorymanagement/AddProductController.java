/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import inventorymanagement.Product;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class AddProductController implements Initializable {
    
    static Part tempProductPart;
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
    @FXML TextField productIDField;
    @FXML TextField productNameField;
    @FXML TextField productInvField;
    @FXML TextField productPriceField;
    @FXML TextField productMaxField;
    @FXML TextField productMinField;

    @FXML private TableView<Part> productPartsSearchResultsTable;
    @FXML private TableColumn<Part, Integer> productID;
    @FXML private TableColumn<Part, String> productName;
    @FXML private TableColumn<Part, Double> productPrice;
    @FXML private TableColumn<Part, Integer> productInStock;

    @FXML private TableView<Part> productPartsTable;
    @FXML private TableColumn<Part, Integer> productPartID;
    @FXML private TableColumn<Part, String> productPartName;
    @FXML private TableColumn<Part, Double> productPartPrice;
    @FXML private TableColumn<Part, Integer> productPartInStock;
    
    @FXML
    private void addproductCancel() throws IOException{
        Stage stage = (Stage) productCancelButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void addproduct(Event event) throws IOException{
        tempProduct = new Product(Integer.parseInt(productIDField.getText()),
            productNameField.getText(),
            Double.parseDouble(productPriceField.getText()),
            Integer.parseInt(productInvField.getText()),
            Integer.parseInt(productMinField.getText()),
            Integer.parseInt(productMaxField.getText()));
        MainScreenController.productData.add(tempProduct);
        for(Part p: productParts){
            tempProduct.addAssociatedPart(p);
        }
        productParts.clear();
        tempProduct = null;
        Stage stage = (Stage) productSaveButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML private void addproductpart(Event event) throws IOException {
        tempProductPart = productPartsSearchResultsTable.getSelectionModel().getSelectedItem();
        productParts.add(tempProductPart);
    }

    static ObservableList<Part> productPartsSearchResults = FXCollections.observableArrayList(
            new Part(1, "test", 3.99, 1,1,1),
            new Part(2,"test2",4.99,1,1,1)
    );

    public static ObservableList<Part> productParts = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productID.setCellValueFactory(new PropertyValueFactory<>("partID"));
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        productInStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        productPartsSearchResultsTable.setItems(MainScreenController.data);
        productPartID.setCellValueFactory(new PropertyValueFactory<>("partID"));
        productPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        productPartInStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        productPartsTable.setItems(productParts);
    }

}
