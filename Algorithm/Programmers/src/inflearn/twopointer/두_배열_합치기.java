package inflearn.twopointer;

import java.util.ArrayList;
import java.util.Scanner;

public class 두_배열_합치기 {

    static int firstLength;
    static int secondLength;

    public static String solution(int[] firstArr, int[] secondArr) {
//        StringBuilder sb = new StringBuilder();
//        int resultLength = firstLength + secondLength;
//        int resultIndex = 0;
//
//        int firstIndex = 0;
//        int secondIndex = 0;
//        while(resultIndex < resultLength) {
//            int first = firstIndex < firstLength ? firstArr[firstIndex] : Integer.MAX_VALUE;
//            int second = secondIndex < secondLength ? secondArr[secondIndex] : Integer.MAX_VALUE;
//
//            if(first <= second) {
//                sb.append(first + " ");
//                firstIndex ++;
//            } else {
//                sb.append(second + " ");
//                secondIndex ++;
//            }
//            resultIndex++;
//        }
//
//        return sb.toString();
        ArrayList<Integer> answer = new ArrayList<>();
        int firstIndex = 0, secondIndex = 0;
        while (firstIndex < firstLength && secondIndex < secondLength)
            answer.add(firstArr[firstIndex] < secondArr[secondIndex] ? firstArr[firstIndex++] : secondArr[secondIndex++]);
        while (firstIndex < firstLength) answer.add(firstArr[firstIndex++]);
        while (secondIndex < secondLength) answer.add(secondArr[secondIndex++]);
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        firstLength = sc.nextInt();
        int[] firstArr = new int[firstLength];
        for (int i = 0; i < firstLength; i++) firstArr[i] = sc.nextInt();
        secondLength = sc.nextInt();
        int[] secondArr = new int[secondLength];
        for (int i = 0; i < secondLength; i++) secondArr[i] = sc.nextInt();

        System.out.print(solution(firstArr, secondArr));
    }
}
