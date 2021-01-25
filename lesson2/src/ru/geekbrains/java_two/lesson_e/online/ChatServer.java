package ru.geekbrains.java_two.lesson_e.online;

public class ChatServer {
    private int port;
    private ServerSocketThread server;

    public void start(int port) {
        if (server != null && server.isAlive()) {
            System.out.println("Server already started");
        } else {
            server = new ServerSocketThread("Server", port);
        }
    }

    public void stop() {
        if (server == null || !server.isAlive()) {
            System.out.println("Server is not running");
        } else {
            server.interrupt();
        }
    }
}
