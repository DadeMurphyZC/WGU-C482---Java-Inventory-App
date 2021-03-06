/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static inventorymanagement.MainScreenController.selectedProduct;
import static inventorymanagement.AddProductController.tempProductPart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static inventorymanagement.Parser.parseInt;
import static inventorymanagement.Parser.parseDouble;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class EditProductController implements Initializable {
    
    @FXML
    private Button productSearchButton;
    @FXML
    private TextField productSearchField;
    @FXML
    private Button productPartAddButton;
    @FXML
    private Button productPartDeleteButton;
    @FXML
    private Button productSaveButton;
    @FXML
    private Button productCancelButton;
    @FXML
    Label productIDLabel;
    @FXML
    Label productNameLabel;
    @FXML
    Label productInvLabel;
    @FXML
    Label productPriceLabel;
    @FXML
    Label productMaxLabel;
    @FXML
    Label productMinLabel;
    @FXML
    TextField editproductIDField;
    @FXML
    TextField editproductNameField;
    @FXML
    TextField editproductInvField;
    @FXML
    TextField editproductPriceField;
    @FXML
    TextField editproductMaxField;
    @FXML
    TextField editproductMinField;
    
    @FXML
    private TableView<Part> productPartsSearchResultsTable;
    @FXML
    private TableColumn<Part, Integer> productID;
    @FXML
    private TableColumn<Part, String> productName;
    @FXML
    private TableColumn<Part, Double> productPrice;
    @FXML
    private TableColumn<Part, Integer> productInStock;
    
    @FXML
    private TableView<Part> productPartsTable;
    @FXML
    private TableColumn<Part, Integer> productPartID;
    @FXML
    private TableColumn<Part, String> productPartName;
    @FXML
    private TableColumn<Part, Double> productPartPrice;
    @FXML
    private TableColumn<Part, Integer> productPartInStock;
    
    static Product tempProduct;
    static int tempProductIndex;
    
    @FXML
    private void editproduct(Event event) throws IOException {
        if (MainScreenController.productData.contains(tempProduct)) {
            tempProduct = new Product();
            tempProduct.setProductID(parseInt(editproductIDField));
            tempProduct.setName(editproductNameField.getText());
            tempProduct.setPrice(parseDouble(editproductPriceField));
            tempProduct.setInStock(parseInt(editproductInvField));
            tempProduct.setMin(parseInt(editproductMinField));
            tempProduct.setMax(parseInt(editproductMaxField));
            productPartsTable.getItems().forEach((p) -> {
                tempProduct.addAssociatedPart(p);
            });
            MainScreenController.productData.set(MainScreenController.getTempProductIndex(),tempProduct);
            if(Validator.partMinimum(tempProduct)!=true){
            SceneSwitch tempeditproductscene = new SceneSwitch(productSaveButton,"MainScreen.fxml");
            tempeditproductscene.sceneSwitch();
            } else {
                Validator.showAlert("A product must have at least one part.");
            }
        }
    }
    
    @FXML
    private void addproductCancel() throws IOException {
        if(Confirm.cancel()==true){
            SceneSwitch tempcancelscene = new SceneSwitch(productCancelButton,"MainScreen.fxml");
            tempcancelscene.sceneSwitch();
        }
    }
    
    @FXML
    private void editaddproductpart(Event event) throws IOException {
        tempProductPart = productPartsSearchResultsTable.getSelectionModel().getSelectedItem();
        tempProduct.addAssociatedPart(tempProductPart);
    }
    
    @FXML
    private void editproductdelete(Event event) throws IOException {
        if(Confirm.delete()==true){
            tempProductPart = productPartsTable.getSelectionModel().getSelectedItem();
            tempProduct.getAssociatedParts().remove(tempProductPart);
            tempProduct=null;
        }
    }
    
    static ObservableList<Part> productParts = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempProduct = MainScreenController.productData.get(MainScreenController.getTempProductIndex());
        productPartsTable.setItems(selectedProduct.getAssociatedParts());
        editproductIDField.setDisable(true);
        editproductIDField.setText(String.valueOf(tempProduct.getProductID()));
        editproductNameField.setText(tempProduct.getName());
        editproductInvField.setText(Integer.toString(tempProduct.getInStock()));
        editproductPriceField.setText(Double.toString(tempProduct.getPrice()));
        editproductMaxField.setText(Integer.toString(tempProduct.getMax()));
        editproductMinField.setText(Integer.toString(tempProduct.getMin()));
        productID.setCellValueFactory(new PropertyValueFactory<>("partID"));
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        productInStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        productPartsSearchResultsTable.setItems(MainScreenController.data);
        productPartID.setCellValueFactory(new PropertyValueFactory<>("partID"));
        productPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        productPartInStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));
    }    
    
}
