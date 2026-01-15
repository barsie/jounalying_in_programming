package com.example;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static int userId = 0;
    private static final Map<Integer, PrintWriter> clientWriters = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat server started on port " + PORT);
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                userId++;
                new ClientHandler(socket, userId).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private int clientId;
        private PrintWriter out;

        public ClientHandler(Socket socket, int clientId) {
            this.socket = socket;
            this.clientId = clientId;
        }

        public void run() {
            System.out.println("Client #" + clientId + " connected.");
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.put(clientId, out);

                out.println( clientId + " Welcome to UoPeople ChatApp! Start Chating now with your userId# " + clientId);
                System.out.println("Hit Enter and start typing...");

                String message;
                while ((message = in.readLine()) != null) {
                    broadcast("User#" + clientId + ": " + message);
                }
            } catch (IOException e) {
                System.out.println("Client #" + clientId + " disconnected.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) { e.printStackTrace(); }

                clientWriters.remove(clientId);
                broadcast("User#" + clientId + " has left the chat.");
            }
        }

        private void broadcast(String message) {
            for (PrintWriter writer : clientWriters.values()) {
                writer.println(message);
            }
        }
    }
}

