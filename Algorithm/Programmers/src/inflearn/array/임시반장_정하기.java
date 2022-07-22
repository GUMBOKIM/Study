package inflearn.array;

import java.util.Scanner;

public class 임시반장_정하기 {
    static int[][] arr;
    static int n;

    public static int solution() {
        int student = 0;
        int max = 0;

        for (int i = 0; i < n; i++) { // 기준 학생
            int count = 0;
            for (int j = 0; j < n; j++) { // 같은 반인 애들 찾기
                for (int k = 0; k < 5; k++)
                    if (i != j) {
                        if (arr[i][k] == arr[j][k]) {
//                            System.out.println(i + "는 " + arr[i][k] + "반, " + j + "는 " + arr[j][k] + "반 " + k+ "학년");
                            count++;
                            break;
                        }
                    }
            }
//            System.out.println(i + " " + count);
            if (count > max) {
                max = count;
                student = i;
            }
        }
        return student + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution());
    }
}
