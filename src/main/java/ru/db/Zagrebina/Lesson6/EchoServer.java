package ru.db.Zagrebina.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {

        try(ServerSocket serverSocket= new ServerSocket(8189)) {
            //try-with-resources предназначен для гарантированного закрытия всех сетевых соединений и освобождения ресурсов
            System.out.println("Ждем подключения клиента...");
            Socket socket = serverSocket.accept();//метод возвращает нам обычный сокет, через который будем общаться
            System.out.println("Клиент подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//создадим цикл для чтения сообщений
            while (true){//добавим poison pill
                String message = in.readUTF();//прочитали сообщение клиента
                if ("/end".equalsIgnoreCase(message)){
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Сообщение от клиента: " + message);
                out.writeUTF("[echo] " + message);//шлем обратно это сообщение
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
