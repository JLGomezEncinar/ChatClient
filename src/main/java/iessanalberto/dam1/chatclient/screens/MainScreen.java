package iessanalberto.dam1.chatclient.screens;

import iessanalberto.dam1.chatclient.network.Client;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;



public class MainScreen {
    private VBox root = new VBox();
    private TextArea txtChat = new TextArea();
    private TextField txtMensaje = new TextField();
    private Button btnEnviar = new Button("Enviar");
    private Client client;
    private String nick;

        public void onMessageReceiver (String mensaje){
        Platform.runLater(() -> txtChat.appendText(mensaje + "\n"));

    }


    public MainScreen(Client client) {

            this.nick = pedirNick();
        txtChat.setEditable(false);
        txtMensaje.setPromptText("Escribe tu mensaje");
        root.getChildren().addAll(txtChat,txtMensaje,btnEnviar);
        btnEnviar.setOnAction(event -> {
            enviarMensaje();
        });
        try {
            this.client = client;
            client.setMainScreen(this);
            client.connect();
        } catch (Exception e) {
            txtChat.appendText("Error conectando al servidor: " + e.getMessage() + "\n");
        }
    }

    private String pedirNick() {
        TextInputDialog dialog = new TextInputDialog("Anonimo");
        dialog.setTitle("Nick");
        dialog.setHeaderText("Introduce tu nick:");
        return dialog.showAndWait().orElse("Anonimo");
    }

    private void enviarMensaje() {
        if (!txtMensaje.getText().isEmpty()) {
            String mensaje = txtMensaje.getText();
            client.send("["+nick+"]: "+mensaje);
            txtMensaje.clear();

        }

    }


    public VBox getRoot() {
        return root;
    }


}
