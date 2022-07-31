package level2;


import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

//    public static int solution(int[][] maps) {
//        map = maps;
//        dfs(1, 0, 0);
//        return answer == Integer.MAX_VALUE ? -1 : answer;
//    }
//
//    public static void dfs(int count, int x, int y) {
//        if (count < answer) {
//            if (x == 4 && y == 4) {
//                answer = Math.min(count, answer);
//            } else {
//                for (int i = 0; i < 4; i++) {
//                    int nextX = x + dx[i];
//                    int nextY = y + dy[i];
//                    if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && map[nextX][nextY] == 1) {
//                        map[nextX][nextY] = 0;
//                        dfs(count + 1, nextX, nextY);
//                        map[nextX][nextY] = 1;
//                    }
//                }
//            }
//        }
//    }

    public static int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    public static void bfs(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];

            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;

                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }

        }


    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}
        }));
    }
}
