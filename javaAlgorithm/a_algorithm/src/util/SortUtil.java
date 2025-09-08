package util;

import java.util.Random;

public class SortUtil {
    public static void checkTime(Timer timer){
        long start = System.currentTimeMillis();
        timer.measure();
        long end = System.currentTimeMillis();
        System.out.println("소요시간 " + (end-start));
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] createRandomIntArray(int size){
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            arr[i] = random.nextInt(size*10);
        }
        return arr;
    }
}
