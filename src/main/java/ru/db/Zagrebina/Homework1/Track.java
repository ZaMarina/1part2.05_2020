package ru.db.Zagrebina.Homework1;

public class Track implements Hurdles{
    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean check(int n) {
if (length<n){
    return true;
}
        System.out.println(this + "не может пройти это препятствие");
return false;
    }
}
