package ru.db.Zagrebina.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private Socket socket;
    private DataInputStream in;//поле для чтения сообщения
    private DataOutputStream out;//поле для отправки

    public static void main(String[] args) {

        new Server().start();
    }

    private void start() {

        connection();

        Scanner scanner = new Scanner(System.in);
        Thread Ts = new Thread(() -> {
        while (true) {
            sendMessage(scanner.nextLine());
        }
        });
        Ts.setDaemon(true);
        Ts.start();
    }


    private void connection() {
        Thread T = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8189)) {


                System.out.println("Ждем подключения клиента...");
                Socket socket = serverSocket.accept();//метод возвращает нам обычный сокет, через который будем общаться
                System.out.println("Клиент подключился");
                in = new DataInputStream(socket.getInputStream());
               out = new DataOutputStream(socket.getOutputStream());


                while (true) {
                    String message = in.readUTF();
                    if ("/end".equalsIgnoreCase(message)) {
                        out.writeUTF("/end");
                        break;
                    }
                    System.out.println("Сообщение от клиента: " + message);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        T.start();

    }

    private void sendMessage(String message) {
        try {

            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }






