package inflearn.sort;

import java.util.Scanner;

public class 버블_정렬 {

    public static String solution(int n, int[] line) {
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++) {
                int first = line[i];
                int second = line[j];
                if(first > second) {
                    line[i] = second;
                    line[j] = first;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num: line) sb.append(num + " ");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] line = new int[n];
        for (int i = 0; i < n; i++) line[i] = sc.nextInt();
        System.out.print(solution(n, line));
    }
}
