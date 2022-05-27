package ru.db.Zagrebina.Homework1;

public class Wall implements Hurdles{
    private int length;

    public Wall(int length) {
        this.length = length;
    }
    @Override
    public boolean check(int n) {
        if (length<n){
            return true;
        }else {

            return false;
        }
    }
}
