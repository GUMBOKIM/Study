package inflearn.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의최단거리통로 {

    static int[][] map = new int[7][7];
    static int[][] dis = new int[7][7];
    static int answer = Integer.MAX_VALUE;
    static int nx = 0, ny = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

//    static void DFS(int count) {
//        if (nx == 6 && ny == 6) {
//            answer = Math.min(answer, count);
//            return;
//        }
//        if(count > answer) return;
//        int bx = nx;
//        int by = ny;
//        for (int i = 0; i < 4; i++) {
//            int cx = nx + dx[i];
//            int cy = ny + dy[i];
//            if((0 <= cx && cx < 7) && (0 <= cy && cy < 7) && map[cy][cx] == 0) {
//                map[cy][cx] = 1;
//                nx = cx;
//                ny = cy;
//                DFS(count + 1);
//                map[cy][cx] = 0;
//                nx = bx;
//                ny = by;
//            }
//        }
//    }

    static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        map[y][x] = 1;
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if ((0 <= nx && nx < 7) && (0 <= ny && ny < 7) && map[ny][nx] == 0) {
                    map[ny][nx] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
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
//        DFS(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}