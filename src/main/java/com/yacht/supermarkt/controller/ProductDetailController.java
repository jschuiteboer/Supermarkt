package com.yacht.supermarkt.controller;

import com.yacht.supermarkt.business.ProductManager;
import com.yacht.supermarkt.model.Product;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@FXMLController
public class ProductDetailController {
    @Autowired
    ProductManager productManager;

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

    public Product getProduct() {
        Product product = new Product();

        product.setId(Long.valueOf(this.id.getText()));
        product.setName(this.name.getText());
        product.setPrice(new BigDecimal(this.price.getText()));

        return product;
    }

    public void onSaveClicked() {
        Product product = this.getProduct();

        this.productManager.save(product);
    }
}
