/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cris
 */
public class Inventory {
    private static ArrayList<Product> products;
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    
    public Inventory(){
    }
    
    public void addProduct(Product product){
        products.add(product);
    }
    
    public boolean removeProduct(int id){
        for(Product p: products){
            if(p.getProductID() == id){
                products.remove(p);
            }
        }
        return true;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public void setAllParts(ObservableList<Part> allParts) {
        this.allParts = allParts;
    }
    
    public static Product lookupProduct(int id){
       for(Product p: MainScreenController.productData){
           if(p.getProductID() == id){
               return p;
           }
       }
       return null;
    }
    
    public void updateProduct(int id){
        for(Product p: products) {
            if(p.getProductID() == id){
                products.set(id, p);
            }
        }
    }
    
    public void addPart(Part part){
        allParts.add(part);
    }
    
    public boolean deletePart(Part part){
        for(Part p: allParts) {
            if(p.getPartID() == part.partID){
                allParts.remove(p);
            }
        }
        return true;
    }
    
    public static Part lookupPart(int id){
        for(Part p: MainScreenController.data) {
            if(p.getPartID() == id) {
              return p;  
            }
        }
        return null;
    }
    
    public void updatePart(int id){
        for (Part p: allParts){
            if(p.getPartID() == id){
                allParts.set(id, p);
            }
        }
    }
}   
