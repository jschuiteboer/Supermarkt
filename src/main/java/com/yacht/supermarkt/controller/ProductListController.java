package com.yacht.supermarkt.controller;

import com.yacht.supermarkt.business.ProductManager;
import com.yacht.supermarkt.model.Product;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FXMLController
public class ProductListController {

    @Autowired
    ProductManager productManager;

    @Autowired
    ProductDetailController productDetailController;

    @FXML
    ListView<Product> productList;

    public void initialize() {
        List<Product> products = productManager.getPage(0).getContent();
        this.productList.getItems().addAll(products);

        this.productList.setOnMouseClicked(event -> this.openSelectedProductDetail());
    }

    public void openSelectedProductDetail() {
        Product selectedProduct = productList.getSelectionModel().getSelectedItem();
        productDetailController.setProduct(selectedProduct);
    }
}
