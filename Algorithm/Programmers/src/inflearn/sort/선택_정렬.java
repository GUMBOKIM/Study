package inflearn.sort;

import java.util.Scanner;

public class 선택_정렬 {

    public static String solution(int n, int[] line) {
        for(int i = 0; i < n - 1; i++) {
            int min_index = i;

            // 최솟값을 갖고있는 인덱스 찾기
            for(int j = i + 1; j < n; j++) {
                if(line[j] <line[min_index]) {
                    min_index = j;
                }
            }

            // i번째 값과 찾은 최솟값을 서로 교환
            swap(line, min_index, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num: line) sb.append(num + " ");
        return sb.toString();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] line = new int[n];
        for (int i = 0; i < n; i++) line[i] = sc.nextInt();
        System.out.print(solution(n, line));
    }
}
