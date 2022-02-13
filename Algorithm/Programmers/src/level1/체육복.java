package level1;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] status = new int[n];
        for (int i = 0; i < n; i++) status[i] = 1;
        for (int l : lost) status[l - 1]--;
        for (int r : reserve) status[r - 1]++;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (status[0] > 1 && status[1] == 0) {
                    status[0]--;
                    status[1]++;
                }
            } else if (i == n - 1) {
                if (status[n - 1] > 1 && status[n - 2] == 0) {
                    status[n - 1]--;
                    status[n - 2]++;
                }
            } else {
                if (status[i] > 1 && status[i - 1] == 0) {
                    status[i]--;
                    status[i - 1]++;
                }
                if (status[i] > 1 && status[i + 1] == 0) {
                    status[i]--;
                    status[i + 1]++;
                }

            }
        }

        int answer = 0;
        for (int s : status) if (s > 0) answer++;
        return answer;
    }

    public static void main(String[] args) {
        int[] n_arr = {5, 5, 3};
        int[][] lost_arr = {
                {2, 4},
                {2, 4},
                {3},
        };

        int[][] reserve_arr = {
                {1, 3, 5},
                {3},
                {1}
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(체육복.solution(n_arr[i], lost_arr[i], reserve_arr[i]));
        }
    }
}