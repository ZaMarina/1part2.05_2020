package ru.db.Zagrebina;


import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "2", "6", "7"}, {"5", "9", "5", "9"}, {"2", "1", "7", "4"}, {"4", "1", "5", "8"}};

        try {
            int result = SumElements(arr);
            System.out.println("Общая сумма: " + result);
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }

    }



    public static int SumElements(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
            System.out.println(Arrays.toString(arr[i]));
        }
        return count;
    }

}


