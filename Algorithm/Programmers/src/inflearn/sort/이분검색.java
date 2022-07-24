package inflearn.sort;

import java.util.Scanner;

public class 이분검색 {

    public static int solution(int n, int m, int[] line) {
        int answer = -1;
        sort(n, line);

        int location = n / 2;
        int distance = n / 2;
        while (answer == -1) {
            int now = line[location];
            if(now != m) {
                distance = distance > 2 ? distance / 2 : 1;
                location = now > m ? location - distance: location + distance;
            } else {
                answer = location;
            }
        }

        return answer + 1;
    }

    private static void sort(int n, int[] line) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (line[minIndex] > line[j]) minIndex = j;
            }
            swap(line, i, minIndex);
        }
    }

    private static void swap(int[] line, int i, int minIndex) {
        int temp = line[i];
        line[i] = line[minIndex];
        line[minIndex] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] line = new int[n];
        for (int i = 0; i < n; i++) line[i] = sc.nextInt();
        System.out.print(solution(n, m, line));
    }
}
