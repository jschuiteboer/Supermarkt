package com.yacht.supermarkt.controller;

import com.yacht.supermarkt.business.discountrules.ProductManager;
import com.yacht.supermarkt.model.Product;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FXMLController
public class ProductListController {

    @Autowired
    ProductManager productManager;

    @FXML
    ListView productList;

    public void initialize() {
        List<Product> products = productManager.getPage(0).getContent();
        this.productList.getItems().addAll(products);
    }

    @FXML
    private void onButtonClicked(final Event event) {
    }
}
