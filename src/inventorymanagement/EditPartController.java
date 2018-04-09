/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import static inventorymanagement.AddProductController.productParts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cfonseca
 */
public class EditPartController implements Initializable {

    @FXML
    private Label mainScreenLabel;
    @FXML
    private ToggleGroup edittoggle;
    @FXML
    private Button editpartsave;
    @FXML
    private Button editpartcancel;
    @FXML
    private Label editpartchoicelabel;
    @FXML
    private RadioButton editpartinhouse;
    @FXML
    private RadioButton editpartoutsourced;
    @FXML
    private TextField editpartId;
    @FXML
    private TextField editpartName;
    @FXML
    private TextField editpartInv;
    @FXML
    private TextField editpartPrice;
    @FXML
    private TextField editpartMax;
    @FXML
    private TextField editpartMin;
    @FXML
    private TextField editpartCName;

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

    static Part tempPart;

    @FXML
    private void editpartradioswitch(ActionEvent event) {
        if (editpartinhouse.isSelected()) {
            editpartchoicelabel.setText("Machine ID");
        }
        if (editpartoutsourced.isSelected()) {
            editpartchoicelabel.setText("Company Name");
        }
    }

    @FXML
    private void editpart(Event event) throws IOException {
        if (MainScreenController.data.contains(tempPart)) {
            tempPart = new Part(Integer.parseInt(editpartId.getText()),
                    editpartName.getText(),
                    Integer.parseInt(editpartInv.getText()),
                    (int) Double.parseDouble(editpartPrice.getText()),
                    Integer.parseInt(editpartMax.getText()),
                    Integer.parseInt(editpartMin.getText()));
            MainScreenController.data.set(MainScreenController.getTempPartIndex(), tempPart);
            Stage stage = (Stage) editpartsave.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void editpartCancel() throws IOException {
        Stage stage = (Stage) editpartcancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deletepart(Event event) throws IOException {
        if (MainScreenController.data.contains(tempPart)) {
            MainScreenController.data.remove(tempPart);
        }
        Stage stage = (Stage) editpartsave.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempPart = MainScreenController.data.get(MainScreenController.getTempPartIndex());
        System.out.println(tempPart.getName() + " " + tempPart.getPartID());
        editpartId.setText(String.valueOf(tempPart.getPartID()));
        editpartName.setText(tempPart.getName());
        editpartInv.setText(Integer.toString(tempPart.getInStock()));
        editpartPrice.setText(Double.toString(tempPart.getPrice()));
        editpartMax.setText(Integer.toString(tempPart.getMax()));
        editpartMin.setText(Integer.toString(tempPart.getMin()));
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
