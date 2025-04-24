package iessanalberto.dam1.chatclient.navigation;

import iessanalberto.dam1.chatclient.network.Client;
import iessanalberto.dam1.chatclient.screens.MainScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigation {
    private static Stage stage = new Stage();
    public static void navigate (String destination,Client client) {
        switch (destination) {
            case "MainScreen" -> {
                MainScreen mainScreen = new MainScreen(client);
                Scene mainScene = new Scene(mainScreen.getRoot(),320,240);
                stage.setTitle("Chat");
                stage.setScene(mainScene);
                stage.show();
            }
        }
    }
}
