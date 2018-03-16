package com.yacht.supermarkt;

import com.yacht.supermarkt.view.InventoryView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) {
        App.launchApp(App.class, InventoryView.class, args);
    }
}
