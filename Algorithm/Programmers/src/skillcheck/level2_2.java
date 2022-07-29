package skillcheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class level2_2 {
//    public static ArrayList<int[]> cases = new ArrayList<>();
//    public static int score = Integer.MIN_VALUE;
//    public static int[] ryan;
//    public static int[] apeach;
//
//    public static int[] solution(int n, int[] info) {
//        ryan = new int[11];
//        apeach = info;
//
//        dfs(n, 0, 0);
//        if(score == Integer.MIN_VALUE) return new int[]{-1};
//
//        Collections.sort(cases, (a1, a2) -> {
//            for(int i = 10; i >= 0; i--) if(a1[i] != a2[i]) return a2[i] - a1[i];
//            return 0;
//        });
//
//        return cases.get(0);
//
//    }
//
//    public static void dfs(int n, int depth, int start) {
//        if(depth == n) {
//            int tempScore = 0;
//            for(int i = 0; i < 10; i++) {
//                if(apeach[i] == 0 && ryan[i] == 0) continue;
//                if(apeach[i] >= ryan[i]) tempScore -= (10 - i);
//                else score += (10 - i);
//            }
//
//            if(tempScore > 0) {
//                if(tempScore > score) {
//                    score = tempScore;
//                    cases.clear();
//                    cases.add(ryan.clone());
//                } else if(tempScore == score) cases.add(ryan.clone());
//            }
//            return;
//        }
//
//        for(int i = start; i <= 10; i++) {
//            ryan[i]++;
//            dfs(n, depth + 1, i);
//            ryan[i]--;
//        }
//    }

    public static ArrayList<int[]> list = new ArrayList<int[]>();
    public static int max_diff = -1;
    public static int[] ryan;
    public static int[] apeach;

    public static int[] solution(int n, int[] info) {
        int[] answer = {};
        ryan = new int[11];
        apeach = info;

        dfs(n, 0, 0);
        if(max_diff == -1) return new int[]{-1};

        Collections.sort(list, (o1, o2) -> {
            for(int i=10;i>=0;i--){
                if(o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });

        return list.get(0);
    }

    public static void dfs(int n, int depth, int start){
        if(depth == n){
            int a_sum = 0;
            int r_sum = 0;
            for(int i=0;i<10;i++){
                if(apeach[i] == 0 && ryan[i] == 0) continue;
                if(apeach[i] >= ryan[i]) a_sum += (10-i);
                else r_sum += (10-i);
            }

            if(r_sum > a_sum){
                int diff = r_sum - a_sum;
                if(max_diff < diff){
                    max_diff = diff;
                    list.clear();
                    list.add(ryan.clone());
                } else if(max_diff == diff){
                    list.add(ryan.clone());
                }
            }

            return;
        }

        for(int i=start;i<11;i++){
            ryan[i]++;
            dfs(n, depth+1, i);
            ryan[i]--;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0})));
    }
}
