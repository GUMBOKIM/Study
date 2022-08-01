package level2;

import java.util.Arrays;

public class 땅따먹기 {
//    static int row = 0, answer = 0;
//    static int[][] lands;
//    static int solution(int[][] land) {
//        row = land.length;
//        lands = land;
//        for (int i = 0; i < 4; i++) dfs(i, 0, 0);
//        return answer;
//    }
//
//    static void dfs(int before, int level, int count) {
//        if(level == row){
//            answer = Math.max(count, answer);
//        } else {
//            for (int i = 0; i < 4; i++) {
//                if(before != i) {
//                    dfs(i, level + 1, count + lands[level][i]);
//                }
//            }
//        }
//    }

    public static int solution(int[][] land) {
        for(int i=1; i< land.length; i++){
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) answer = Math.max(answer, land[land.length -1][i]);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
