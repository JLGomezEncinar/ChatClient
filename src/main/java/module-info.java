module iessanalberto.dam1.chatclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens iessanalberto.dam1.chatclient to javafx.fxml;
    exports iessanalberto.dam1.chatclient;
    exports iessanalberto.dam1.chatclient.screens;
    opens iessanalberto.dam1.chatclient.screens to javafx.fxml;
}