package ru.db.Zagrebina.Homework5;

//домашняя работа. Один поток и два потока

public class Task5 {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;

    public static float[] count(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    public void firstMethod() {

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        count(arr);

        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

    }


    public void secondMethod() {

        float[] arr = new float[SIZE];
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, leftHalf, 0, (HALF));
        System.arraycopy(arr, HALF, rightHalf, 0, (HALF));
        System.out.println("Разбивка: " + (System.currentTimeMillis() - startTime) + " ms.");

        Thread thread1 = new Thread(() -> {
            long startTime1 = System.currentTimeMillis();

            count(leftHalf);
            System.out.println("Расчет левой половины: " + (System.currentTimeMillis() - startTime1) + " ms.");

        });

        Thread thread2 = new Thread(() -> {
            long startTime2 = System.currentTimeMillis();
            count(rightHalf);
            System.out.println("Расчет правой половины: " + (System.currentTimeMillis() - startTime2) + " ms.");

        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long startTime3 = System.currentTimeMillis();
        float[] mergedArray = new float[SIZE];

        System.arraycopy(leftHalf, 0, mergedArray, 0, HALF);
        System.arraycopy(rightHalf, 0, mergedArray, HALF, HALF);
        System.out.println("Расчет склейки: " + (System.currentTimeMillis() - startTime3) + " ms.");


        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }


    public static void main(String[] args) {
        Task5 task5 = new Task5();
        task5.firstMethod();
        task5.secondMethod();

    }
}
