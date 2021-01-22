package ru.geekbrains.java_two.lesson_f.online;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server awaits for connections");
            Socket clientThatConnectedToUs = server.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(clientThatConnectedToUs.getInputStream());
            DataOutputStream out = new DataOutputStream(clientThatConnectedToUs.getOutputStream());
            while (true) {
                String msg = in.readUTF();
                System.out.println("Msg from client: " + msg);
                out.writeUTF("Echo: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
