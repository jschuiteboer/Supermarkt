package com.yacht.supermarkt;

import com.yacht.supermarkt.view.ProductListView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) {
        App.launchApp(App.class, ProductListView.class, args);
    }
}
