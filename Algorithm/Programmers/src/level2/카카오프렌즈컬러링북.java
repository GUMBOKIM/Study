package level2;

import java.util.Arrays;
import java.util.HashMap;

public class 카카오프렌즈컬러링북 {

    static int row;
    static int col;
    static int[][] visit;
    static int[][] book;
    static int area;

    public static void find(int i, int j, int color) {
        if(visit[i][j] == -1 && book[i][j] == color) {
            visit[i][j] = color;
            area++;
            //위
            if (row > i + 1 && visit[i + 1][j] == -1) find(i + 1, j, color);
            //아
            if (i - 1 >= 0 && visit[i - 1][j] == -1) find(i - 1, j, color);
            //왼
            if (j - 1 >= 0 && visit[i][j - 1] == -1) find(i, j - 1, color);
            //오
            if (col > j + 1 && visit[i][j + 1] == -1) find(i, j + 1, color);
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        row = m;
        col = n;
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = -1;
            }
        }
        book = picture;

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == -1) {
                    area = 0;
                    int color = picture[i][j];
                    find(i, j, color);
                    if(color != 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(카카오프렌즈컬러링북.solution(m, n, picture)));
    }
}