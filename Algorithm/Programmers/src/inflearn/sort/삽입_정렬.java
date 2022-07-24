package inflearn.sort;

import java.util.Scanner;

public class 삽입_정렬 {

    public static String solution(int n, int[] line) {
        for(int i = 1; i < n; i++) {
            // 현재 선택된 원소의 값을 임시 변수에 저장해준다.
            int temp = line[i];
            // 현재 원소를 기준으로 이전 원소를 탐색하기 위한 index 변수.
            int prev = i - 1;
            // 현재 선택된 원소가 이전 원소보다 작은 경우까지만 반복. 단, 0번째 원소까지만 비교한다.
            while(prev >= 0 && line[prev] > temp) {
                // 현재 선택된 원소가 현재 탐색중인 원소보다 작다면, 해당 원소는 다음 인덱스로 미뤄버린다.
                line[prev + 1] = line[prev];
                // 다음 대상 원소를 탐색한다.
                prev--;
            }
            // 탐색이 종료된 지점에 현재 선택되었던 변수의 값을 삽입해준다.
            line[prev + 1] = temp;
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
