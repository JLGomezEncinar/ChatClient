package iessanalberto.dam1.chatclient.network;

public interface ChatListener {

    public default void onMessageReceiver(String mensaje) {
    }
}
