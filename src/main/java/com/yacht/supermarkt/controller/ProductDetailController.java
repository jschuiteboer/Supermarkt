package com.yacht.supermarkt.controller;

import com.yacht.supermarkt.model.Product;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@FXMLController
public class ProductDetailController {
    @FXML
    TextField id;

    @FXML
    TextField name;

    @FXML
    TextField price;

    public void setProduct(Product product) {
        this.id.setText(product.getId().toString());
        this.name.setText(product.getName());
        this.price.setText(product.getPrice().toString());
    }
}
