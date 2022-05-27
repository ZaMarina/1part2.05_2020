package ru.db.Zagrebina;

//сделали непроверяемым исключение
public class MyNotFoudFileException extends RuntimeException {

    public MyNotFoudFileException(String msg, Throwable cause) {

        super(msg, cause);
    }
}
