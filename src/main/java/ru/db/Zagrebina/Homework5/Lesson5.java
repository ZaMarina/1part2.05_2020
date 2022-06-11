package ru.db.Zagrebina.Homework5;

//из методички
public class Lesson5 {
    public class SynchCounter {
        private long first = 0;
        private long second = 0;

        private Object monFirst = new Object();
        private Object monSecond = new Object();


        public long getFirst() {
            return first;
        }

        public long getSecond() {
            return second;
        }

        public synchronized void incrementFirst() {
            synchronized (monFirst) {
                first++;
            }
        }

        public synchronized void incrementSecond() {
            synchronized (monSecond) {
                second++;
            }
        }

        public synchronized void decrementFirst() {
            synchronized (monFirst) {
                first--;
            }
        }

        public synchronized void decrementSecond() {
            synchronized (monSecond) {
                second--;
            }
        }
    }


    private final Object mon = new Object();
    private volatile char currentLetter = 'A';


    public static void main(String[] args) {
        Lesson5 waitNotifyApp = new Lesson5();
        Thread thread1 = new Thread(() -> {
            waitNotifyApp.printA();
        });
        Thread thread2 = new Thread(() -> {
            waitNotifyApp.printB();
        });
        thread1.start();
        thread2.start();

    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notify();
                }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }


    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'A';
                    mon.notify();
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

