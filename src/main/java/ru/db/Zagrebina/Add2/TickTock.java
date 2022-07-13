package ru.db.Zagrebina.Add2;

public class TickTock {

    String state;

    synchronized void tick(boolean running){
        if (!running){
            state = "ticked";
            notify();
            return;
        }
        System.out.print("Tick ");

        state = "ticked";
        notify();

        try {
                while (!state.equals("tocked"))
                    wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("printStackTrace");
        }
    }

    synchronized void tock(boolean running){
        if (!running){
            state = "tocked";
            notify();
            return;
        }
        System.out.println("Tock");

        state = "tocked";
        notify();

        try {
            while (!state.equals("ticked"))
                wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("printStackTrace");
        }
    }
}
 class MyThread implements Runnable{
    Thread thrd;
    TickTock tt;

     public MyThread(String name, TickTock tt) {
         thrd = new Thread(thrd,name);
         this.tt = tt;
         //thrd.start();
     }

     @Override
     public void run() {
         if (thrd.getName().compareTo("Tick") == 0) {
             for (int i = 0; i < 5; i++) {
                 tt.tick(true);
             }
             tt.tick(false);
         } else {
             for (int i = 0; i < 5; i++) {
                 tt.tock(true);
             }
             tt.tock(false);
         }
     }
 }
 class Com{
     public static void main(String[] args) {
         TickTock tt = new TickTock();
         Thread mt1 = new Thread(new MyThread("Tick",tt));
         Thread mt2 = new Thread(new MyThread("Tock",tt));


         try {
             mt1.start();
             mt2.start();
             mt1.join();
             mt2.join();
         }catch (InterruptedException e){
             e.printStackTrace();
         }
     }
 }

