package inflearn.DFSBFS;

import java.util.Scanner;

public class 미로탐색 {

    static int[][] map = new int[7][7];
    static int answer = 0;
    static int nx = 0, ny = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

//    static void DFS() {
//        if (nx == 6 && ny == 6) {
//            answer++;
//            return;
//        }
//        int bx = nx;
//        int by = ny;
//        for (int i = 0; i < 4; i++) {
//            int cx = nx + dx[i];
//            int cy = ny + dy[i];
//            if((0 <= cx && cx < 7) && (0 <= cy && cy < 7) && map[cy][cx] == 0) {
//                map[cy][cx] = 1;
//                nx = cx;
//                ny = cy;
//                DFS();
//                map[cy][cx] = 0;
//                nx = bx;
//                ny = by;
//
//            }
//        }
//    }

    static void DFS(int x, int y) {
        if (x == 6 && y == 6) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if ((0 <= nx && nx < 7) && (0 <= ny && ny < 7) && map[ny][nx] == 0) {
                    map[ny][nx] = 1;
                    DFS(nx, ny);
                    map[ny][nx] = 0;

                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        map[0][0] = 1;
//        DFS();
        DFS(0,0);
        System.out.println(answer);
    }
}
