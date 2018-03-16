package com.yacht.supermarkt;

import com.yacht.supermarkt.view.MainView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) {
        App.launchApp(App.class, MainView.class, args);
    }
}
