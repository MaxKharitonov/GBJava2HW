package Java2HW.lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyServer {

    private final Map<String, ClientHandler> clients;

    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        this.clients = new HashMap<>();
        int PORT = 8189;
        try (ServerSocket server = new ServerSocket(PORT)) {
            authService = new BaseAuthService();
            authService.start();
            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Пользователь подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            System.out.println("Ошибка в работе сервера");
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized boolean isNickBusy(String nick) {
        return clients.containsKey(nick);
    }

    public synchronized void broadcast(String message) {
        clients.values().forEach(client -> client.sendMsg(message));
    }

    public void sendPrivateMessage(String from, String to, String message) {
        ClientHandler sender = clients.get(from);
        ClientHandler receiver = clients.get(to);

        if (receiver == null) {
            sender.sendMsg("Сервер: пользователь " + to + " бездействует.");
            return;
        }

        receiver.sendMsg(message);

    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client.getName());
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.put(client.getName(), client);
    }
}