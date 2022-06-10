package ru.db.Zagrebina.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        //напишем сервер(в методе main)
        //IPv4(19.168.0.1) - числа меняются от 0 до 255//32 бита, 4 байт
        // IPv6 //128 бит, 16 байт
        //конструктор принимает порт - это получатель, куда что шлем

        try(ServerSocket serverSocket= new ServerSocket(8189)) { //try-with-resource - вместо finally
            // в скобках те ресурсы, которые мы хотим чтобы были закрыты автоматически. Сюда можно поместить класс который имплементирует Closable
            System.out.println("Ждем подключения клиента...");
            Socket socket = serverSocket.accept();//метод возвращает нам обычный сокет, через который будем общаться
            System.out.println("Клиент подключился");
            //Для того чтобы получать сообщения из этого сокета, создадим стримы для ввода/вывода
            DataInputStream in = new DataInputStream(socket.getInputStream());//для чтения входящих сообщений
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());//отсылаем сообщения обратно клиенту
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
//        } finally {//необходимо гарантировано закрыть сокет
//            if (serverSocket != null) {
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }
}
