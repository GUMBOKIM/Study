package inflearn.sort;

import java.util.Scanner;

public class 좌표_정렬 {
    public static void solution(int n, int[][] points) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if(points[minIndex][0] > points[j][0]) {
                    minIndex = j;
                } else if(points[minIndex][0] == points[j][0] && points[minIndex][1] > points[j][1]){
                    minIndex = j;
                }
            }
            swap(i, minIndex, points);
        }
        print(points);
    }

    public static void swap(int i, int j, int[][] points) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void print(int[][] points){
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        solution(n, points);
    }
}
