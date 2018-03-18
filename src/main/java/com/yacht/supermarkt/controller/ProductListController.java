package com.yacht.supermarkt.controller;

import com.yacht.supermarkt.business.ProductManager;
import com.yacht.supermarkt.event.ProductSavedEvent;
import com.yacht.supermarkt.model.Product;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

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
        this.initListItems();

        this.productList.setOnMouseClicked(event -> this.openSelectedProductDetail());
    }

    public void openSelectedProductDetail() {
        Product selectedProduct = productList.getSelectionModel().getSelectedItem();
        productDetailController.setProduct(selectedProduct);
    }

    @EventListener
    public void onProductSaved(ProductSavedEvent e) {
        this.initListItems();
    }

    private void initListItems() {
        List<Product> products = productManager.getPage(0).getContent();
        this.productList.getItems().setAll(products);
    }
}
