package ru.db.Zagrebina.Lesson6;

import ru.db.Zagrebina.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new Client().start();

    }

    private void start() {

            try {
                openConnection();//метод, который открое соединение сервера
                Scanner scanner = new Scanner(System.in);

                Thread T = new Thread(() -> {
                while (true) {
                    if (socket.isClosed()) {
                        System.out.println("сработало");
                        break;
                    }
                    sendMessage(scanner.nextLine());

                }
                });
                T.setDaemon(true);
                T.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    private void sendMessage(String message) {
        //пишем метод который будет нам слать сообщения
        try {
            System.out.println(message);
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void openConnection() throws IOException {
        socket = new Socket("127.0.0.1", 8189);//указывается IP адрес и порт
        //далее инициализируем наши классы для записи сообщений
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    if ("/end".equalsIgnoreCase(message)) {

                        sendMessage(message);

                        break;
                    }
                    System.out.println("Сообщение от сервера: " + message);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                closeConnection();
            }
        }).start();
    }

    private void closeConnection() {
        //закрываем потоки ввода/вывода
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket != null) {
            try {

                socket.close();
                System.out.println("соединение закрыто? " + socket.isClosed());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
