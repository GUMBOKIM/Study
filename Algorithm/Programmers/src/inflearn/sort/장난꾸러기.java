package inflearn.sort;

import java.util.*;

public class 장난꾸러기 {

    public static String solution(int n, int[] line) {
        int[] sorted = line.clone();

        for(int i = 1; i < n; i++) {
            int temp = sorted[i];
            int prev = i - 1;
            while(prev >= 0 && sorted[prev] > temp) {
                sorted[prev + 1] = sorted[prev];
                prev--;
            }
            sorted[prev + 1] = temp;
        }

        boolean isFirstFind = false;
        int first = 0;
        int second = 0;

        for (int i = 0; i < n; i++) {
            if(line[i] != sorted[i]) {
                if(!isFirstFind) {
                    first = i + 1;
                    isFirstFind = true;
                } else {
                    second = i + 1;
                    break;
                }
            }
        }

        return first + " " + second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] line = new int[n];
        for (int i = 0; i < n; i++) line[i] = sc.nextInt();
        System.out.print(solution(n, line));
    }
}
