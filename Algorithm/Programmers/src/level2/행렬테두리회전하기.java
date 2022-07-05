package level2;

import java.util.*;

public class 행렬테두리회전하기 {

    static int[][] table;

    public static int[] solution(int rows, int columns, int[][] queries) {
        createTable(rows, columns);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            System.out.println("i = " + i);
            answer[i] = rotateTable(queries[i]);
        }
        return answer;
    }

    public static void createTable(int rows, int columns) {
        table = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = value;
                value++;
            }
        }
    }

    public static int rotateTable(int[] query) {
        int startRow = query[0] - 1;
        int startCol = query[1] - 1;
        int endRow = query[2] - 1;
        int endCol = query[3] - 1;

        Deque<Integer> dq = new ArrayDeque<>();
        // >
        for (int col = startCol; col < endCol; col++) dq.addLast(table[startRow][col]);
        // v
        for (int row = startRow; row < endRow; row++) dq.addLast(table[row][endCol]);
        // <
        for (int col = endCol; col > startCol; col--) dq.addLast(table[endRow][col]);
        // ^
        for (int row = endRow; row > startRow; row--) dq.addLast(table[row][startCol]);

        int min = Collections.min(dq);

        dq.addFirst(dq.pollLast());

        // >
        for (int col = startCol; col < endCol; col++) table[startRow][col] = dq.pollFirst();
        // v
        for (int row = startRow; row < endRow; row++) table[row][endCol] = dq.pollFirst();
        // <
        for (int col = endCol; col > startCol; col--) table[endRow][col] = dq.pollFirst();
        // ^
        for (int row = endRow; row > startRow; row--) table[row][startCol] = dq.pollFirst();

        for (int[] row: table) {
            System.out.println("Arrays.toString(table) = " + Arrays.toString(row));
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] answer = solution(6, 6, queries);
        System.out.println(Arrays.toString(answer));
    }
}
