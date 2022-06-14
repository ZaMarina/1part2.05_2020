package ru.db.Zagrebina.Homework5;
//сделать разбивку на кучу потоков

import java.util.Arrays;

public class Multithreading {
    private static final int SIZE = 3_000_000;
    private static final int CHUNK_COUNT = 8;

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        final Multithreading main = new Multithreading();
        float[] a = new float[SIZE];

        Arrays.fill(a, 1f );

        long start = System.currentTimeMillis();
        main.count1(a, 0);
        final long result1 = System.currentTimeMillis() - start;
        System.out.println("Время работы в один поток: " + result1);

        start = System.currentTimeMillis();
        main.count2(a, CHUNK_COUNT);
        final long result2 = System.currentTimeMillis() - start;
        System.out.println("Время работы в несколько поток: " + result2);

        System.out.println("Отношение: " + ((double)result1/result2));
    }

    public void count1(float[] arr, int offcet) {//добавили сдвиг
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i+offcet) / 5) * Math.cos(0.2f + (i+offcet) / 5) * Math.cos(0.4f + (i+offcet) / 2));
        }
    }


    public void count2(float[] a, int threadCount) {
        int chunkSize = a.length/threadCount;//определяем размер массива на который разбиваем
        float[][]chunks = new float[threadCount][chunkSize];//[колличество тредов][длина чанга]
        Thread[] t = new Thread[threadCount];//создали массив из тредов
        for (int i = 0, c=0; i < a.length; i+=chunkSize, c++) {
         chunks[c] = Arrays.copyOfRange(a,i, Math.min(i+chunkSize, a.length));
         final int j=c;
            int finali = i;
         t[j] = new Thread(()->count1(chunks[j], finali));
         t[j].start();
    }
        for (int i = 0; i < threadCount; i++) {
            try {
                t[i].join();//метод join() вызывается для каждого треда(для каждого элемента массива)
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            }
        //после того как мы дождались завершения всех тредов, мы массив обратно склеиваем
        for (int i = 0, c=0; i < a.length; i+=chunkSize, c++) {
            System.arraycopy(chunks[c], 0, a, i, chunks[c].length);
        }
        }
}
