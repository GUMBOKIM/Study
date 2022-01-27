package ch03;

import java.util.Arrays;
import java.util.Scanner;

public class ex3_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int h = sc.nextInt();

        int result = 0;

        for (int i = 0; i < v; i++) {
            int min = 10001;
            for(int j = 0; j < h; j++){
                min = Math.min(min, sc.nextInt());
            }
            result = Math.max(result, min);
        }
        System.out.println("result = " + result);
    }
}
