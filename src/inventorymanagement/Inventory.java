/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cris
 */
public class Inventory {

    private static ObservableList<Product> products = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public Inventory() {
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int id) {
        products.stream().filter((p) -> (p.getProductID() == id)).forEachOrdered((p) -> {
            products.remove(p);
        });
        return true;
    }

    public static ObservableList<Product> getProducts() {
        return products;
    }

    public void setProducts(ObservableList<Product> products) {
        Inventory.products = products;
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public void setAllParts(ObservableList<Part> allParts) {
        Inventory.allParts = allParts;
    }

    public static Product lookupProduct(int id) {
        for (Product p : MainScreenController.productData) {
            if (p.getProductID() == id) {
                return p;
            }
        }
        return null;
    }

    public void updateProduct(int id) {
        products.stream().filter((p) -> (p.getProductID() == id)).forEachOrdered((p) -> {
            products.set(id, p);
        });
    }

    public void addPart(Part part) {
        allParts.add(part);
    }

    public boolean deletePart(Part part) {
        allParts.stream().filter((p) -> (p.getPartID() == part.partID)).forEachOrdered((p) -> {
            allParts.remove(p);
        });
        return true;
    }

    public static Part lookupPart(int id) {
        for (Part p : MainScreenController.data) {
            if (p.getPartID() == id) {
                return p;
            }
        }
        return null;
    }

    public void updatePart(int id) {
        allParts.stream().filter((p) -> (p.getPartID() == id)).forEachOrdered((p) -> {
            allParts.set(id, p);
        });
    }
}
