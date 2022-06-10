package ru.db.Zagrebina.Lesson6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;



public class EchoClient {

    private Socket socket;
    private DataInputStream in;//поле для чтения сообщения
    private DataOutputStream out;//поле для отправки

    public static void main(String[] args) {
        new EchoClient().start();
    }

    private void start() {
        try {
            openConnection();//метод, который открое соединение сервера
            Scanner scanner = new Scanner(System.in);
            //надо подумать как выходить если клиент ввел /end
            while (!socket.isClosed()){
                sendMessage(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendMessage(String message) {
        //пишем метод который будет нам слать сообщения
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("127.0.0.1", 8189);//указывается IP адрес и порт(локал хост, т.е. сама машина, и указали порт как в сервере)
        //далее инициализируем наши классы для записи сообщений
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
new Thread(()->{
    try {
        while (true){
            String message = in.readUTF();//метод ожидает сообщение от сервера
            if ("/end".equalsIgnoreCase(message)){
                break;
            }
            System.out.println("Сообщение от сервера: " + message);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        closeConnection();
    }
}).start();

    }

    private void closeConnection() {
        //1. закрываем потоки ввода вывода
        if (in!= null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out!= null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket!=null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
