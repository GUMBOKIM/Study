package level1;

import java.util.Stack;

public class 크레인인형뽑기게임 {

    public static int solution(int[][] board, int[] moves) {
        int width_size = board[0].length;

        Stack<Integer>[] stack_Arr = new Stack[width_size];
        for (int i = 0; i < width_size; i++) {
            stack_Arr[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            int[] board_layer = board[i];
            for (int j = 0; j < width_size; j++) {
                int doll = board_layer[j];
                if (doll != 0) {
                    stack_Arr[j].add(doll);
                }
            }
        }

        Stack<Integer> result_stack = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            if (!stack_Arr[move - 1].empty()) {
                int now = stack_Arr[move - 1].pop();
                if (!result_stack.empty()) {
                    int before = result_stack.pop();
                    if (now == before) answer += 2;
                    else {
                        result_stack.add(before);
                        result_stack.add(now);
                    }
                } else result_stack.add(now);

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(크레인인형뽑기게임.solution(board, moves));
    }
}