package iessanalberto.dam1.chatclient.network;

import iessanalberto.dam1.chatclient.screens.MainScreen;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;

public class Client {
    private String servidor = "54.166.57.115";
    private int puerto = 12345;
    private Socket socket;
    private MainScreen mainScreen;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public Client(String servidor, int puerto) {
        this.servidor = servidor;
        this.puerto = puerto;

    }

    public void connect() {
        new Thread(() -> {
            try {
                socket = new Socket(servidor, puerto);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter = new PrintWriter(socket.getOutputStream(),true);
                String linea = null;

                while ((linea = bufferedReader.readLine()) != null){
                    String finalLinea = linea;
                    Platform.runLater(()->mainScreen.onMessageReceiver(finalLinea));


                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void send(String mensaje) {
        if (printWriter != null) {
            printWriter.println(mensaje);
        }
    }

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }
}
