package ru.db.Zagrebina;

public class Track implements Obstacles {
    private int Length;

    public Track(int value) {
        this.Length = value;
    }

    @Override
    public void overcome(Persons persons) {
persons.run(this);
    }
    @Override
    public String toString() {
        return "Беговая дорожка " + Length + " метров";
    }

    public int getLength() {
        return Length;
    }
}
