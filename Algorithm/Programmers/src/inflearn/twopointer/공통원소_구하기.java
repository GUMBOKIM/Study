package inflearn.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class 공통원소_구하기 {


    public static String solution(int firstLength, int secondLength, int[] firstArr, int[] secondArr) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        int firstIndex = 0, secondIndex = 0;
        while(firstIndex < firstLength && secondIndex < secondLength) {
            int firstNow = firstArr[firstIndex];
            int secondNow = secondArr[secondIndex];
            if(firstNow == secondNow) {
                sb.append(firstNow + " ");
                firstIndex ++;
                secondIndex ++;
            } else if(firstNow > secondNow) {
                secondIndex ++;
            } else {
                firstIndex ++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstLength = sc.nextInt();
        int[] firstArr = new int[firstLength];
        for (int i = 0; i < firstLength; i++) firstArr[i] = sc.nextInt();
        int secondLength = sc.nextInt();
        int[] secondArr = new int[secondLength];
        for (int i = 0; i < secondLength; i++) secondArr[i] = sc.nextInt();

        System.out.print(solution(firstLength, secondLength, firstArr, secondArr));
    }
}
