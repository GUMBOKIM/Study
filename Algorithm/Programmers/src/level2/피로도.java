package level2;

public class 피로도 {
    static int K, L;
    static int[][] D;
    static int[] check;
    static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        K = k;
        L = dungeons.length;
        D = dungeons;
        check = new int[L];
        DFS(0, K, 0);
        return answer;
    }

    public static void DFS(int l, int k, int count) {
        if(l == L) answer = Math.max(answer, count);
        else {
            for (int i = 0; i < L; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    if (k >= D[i][0]) DFS(l + 1, k - D[i][1], count + 1);
                    else DFS(l + 1, k, count);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }
}
