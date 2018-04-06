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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static inventorymanagement.Inventory.lookupPart;
import static inventorymanagement.Inventory.lookupProduct;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * FXML Controller class
 *
 * @author cris
 */
public class MainScreenController implements Initializable {

    private static int tempPartIndex;
    public static int getTempPartIndex() {
        return tempPartIndex;
    }
    
    private static int tempProductIndex;
    public static int getTempProductIndex() {
        return tempProductIndex;
    }
    

    @FXML private Label mainScreenLabel;
    @FXML private Button addPartButton;
    @FXML private Button addProductButton;
    @FXML private Button editPartButton;
    @FXML private Button searchPartButton;
    @FXML private Button clearSearchPartButton;
    @FXML private TextField searchField;
    @FXML private TextField searchProductField;
    @FXML private Button searchProductButton;
    @FXML private Button clearSearchProductButton;
    @FXML private Button deleteProductButton;
    @FXML private Button editProductButton;

    @FXML private TableView<Part> partsTable;
    @FXML private TableColumn<Part, Integer> partIDCol;
    @FXML private TableColumn<Part, String> name;
    @FXML private TableColumn<Part, Double> price;
    @FXML private TableColumn<Part, Integer> inStock;

    @FXML private TableView<Product> productsTable;
    @FXML private TableColumn<Product, Integer> productIDCol;
    @FXML private TableColumn<Product, String> productName;
    @FXML private TableColumn<Product, Double> productPrice;
    @FXML private TableColumn<Product, Integer> productinStock;

    //MAPS THE ADD BUTTON TO setAddPartScene AND CHANGES TO THE Add Part VIEW
    @FXML
    private void setAddPartScene(Event event) throws IOException {
        Stage stage = (Stage) addPartButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void setEditPartScene(Event event) throws IOException {
        tempPartIndex = partsTable.getSelectionModel().getSelectedIndex();
        System.out.println(tempPartIndex);
        Stage stage = (Stage) editPartButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("EditPart.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void setEditProductScene(Event event) throws IOException {
        tempProductIndex = productsTable.getSelectionModel().getSelectedIndex();
        System.out.println(tempProductIndex);
        Stage stage = (Stage) editProductButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("EditProduct.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        mainScreenLabel.setText("Edit Product");
    }

    @FXML
    private void setAddProductScene(Event event) throws IOException {
        Stage stage = (Stage) addProductButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deletepart(Event event) throws IOException {
        tempPartIndex = partsTable.getSelectionModel().getSelectedIndex();
        if(Confirm.delete()==true){
            if (data.contains(data.get(tempPartIndex))) {
                data.remove(tempPartIndex);
            }
        partsTable.setItems(data);
        }
    }
    
    @FXML
    private void deleteproduct(Event event) throws IOException {
        tempProductIndex = productsTable.getSelectionModel().getSelectedIndex();
        if (productData.contains(productData.get(tempProductIndex))) {
            productData.remove(tempProductIndex);
        }
        productsTable.setItems(productData);
    }

    @FXML
    private void searchPart() {
        int search = Integer.parseInt(searchField.getText());
        Part tempPart = lookupPart(search);
        if (tempPart != null) {
            ObservableList<Part> searchTable
                    = FXCollections.observableArrayList(new Part(tempPart.getPartID(),
                            tempPart.getName(),
                            tempPart.getPrice(),
                            tempPart.getInStock(),
                            tempPart.getMin(),
                            tempPart.getMax()));
            partsTable.setItems(searchTable);
        }
    }
    
    @FXML
    private void searchProduct() {
        int search = Integer.parseInt(searchProductField.getText());
        System.out.println(search);
        Product tempProduct = lookupProduct(search);
        if (tempProduct != null) {
            ObservableList<Product> searchProductTable 
                    = FXCollections.observableArrayList(new Product(tempProduct.getProductID(),
                            tempProduct.getName(),
                            tempProduct.getPrice(),
                            tempProduct.getInStock(),
                            tempProduct.getMin(),
                            tempProduct.getMax()));
            productsTable.setItems(searchProductTable);
        }
    }

    @FXML
    private void clearPartSearch() {
        searchField.setText("");
        partsTable.setItems(data);
    }
    
    @FXML
    private void clearProductSearch() {
        searchProductField.setText("");
        productsTable.setItems(productData);
    }

    static ObservableList<Part> data = FXCollections.observableArrayList(
            new Part(1, "test", 3.99, 1, 1, 1),
            new Part(2, "test2", 4.99, 1, 1, 1)
    );

    static ObservableList<Product> productData = FXCollections.observableArrayList(
            new Product(1, "test", 3.99, 1, 1, 1),
            new Product(2, "test2", 4.99, 1, 1, 1)
    );

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partIDCol.setCellValueFactory(new PropertyValueFactory<>("partID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        productIDCol.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        productinStock.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        partsTable.setItems(data);
        productsTable.setItems(productData);

        // TODO
    }

}
