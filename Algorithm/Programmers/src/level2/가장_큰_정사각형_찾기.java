package level2;

public class 가장_큰_정사각형_찾기 {
    static int width, height;

    public static int solution(int[][] board) {
        width = board[0].length;
        height = board.length;

        int answer = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1) {
                    System.out.println("-------");
                    System.out.println("y " + i + " x " + j);
                    System.out.println("-------");
                    answer = Math.max(answer, calculate(j, i, 1, board));
                }
            }
        }
        return answer * answer;
    }

    public static int solution2(int[][] board) {
        int answer = 0, row = board.length, col =board[0].length;
        int[][] map = new int[row + 1][col + 1];

        for (int i = 0; i < row; i ++)
            for(int j = 0; j <col; j ++)map[i + 1][j + 1] = board[i][j];

        for (int i = 1; i <= row; i++) for (int j = 1; j <= col; j++) {
            if(map[i][j] != 0) {
                map[i][j] = Math.min(Math.min(map[i - 1][j] , map[i][j - 1]), map[i - 1][j - 1]) + 1;
                answer = Math.max(answer, map[i][j]);
            }
        }
        return answer * answer;
    }

    static int calculate(int x, int y, int count, int[][] board) {
        if (x + count < width && y + count < height){
            for (int i = 0; i < count; i++) {
                if (board[y + count][x + i] == 0) return count;
                System.out.println((y + count) + " " + (x + i));
            }
            for (int i = 0; i < count; i++) {
                System.out.println((y + count) + " " + x + i);
                if (board[y + i][x + count] == 0) return count;
            }
            return calculate(x, y, count + 1, board);
        } else return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }
}
