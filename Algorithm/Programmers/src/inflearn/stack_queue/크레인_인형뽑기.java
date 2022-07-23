package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 크레인_인형뽑기 {

    public static int solution(int n, int[][] arr, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int beforeSelect = 0;

        for (int move : moves) {
            // 뽑기
            int now = 0;
            for (int i = 0; i < n; i++) {
                int temp = arr[i][move - 1];
                if (temp != 0) {
                    now = temp;
                    arr[i][move - 1] = 0;
                    break;
                }
            }

            // 넣기
            if (now != 0) {
                if(beforeSelect == now) {
                    stack.pop();
                    beforeSelect = stack.peek();
                    answer += 2;
                } else {
                    stack.push(now);
                    beforeSelect = now;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.print(solution(n, arr, m, moves));
    }
}
