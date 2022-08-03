package level2;


import java.util.Arrays;

public class 삼각달팽이 {
    public static int[] solution(int n) {
        int[][] tree = new int[n][];
        for (int i = 0; i < n; i++) tree[i] = new int[i + 1];

        int count = 1;
        int number = 1;
        int nx = -1;
        int ny = 0;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, -1}};

        while(count <= n) {
            int[] direction = directions[(count - 1) % 3];
            for (int i = 0; i < n - count + 1; i++) {
                nx += direction[0];
                ny += direction[1];
                tree[nx][ny] = number;
                number++;
            }
            count ++;
        }

        count = 0;
        int[] answer = new int[n * (n + 1) / 2];
        for (int[] t: tree) for (int i: t) {
            answer[count] = i;
            count ++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }
}

// n = 4
// 0,0
// 1,0
// 2,0
// 3,0 - +1, 0


// 3,1
// 3,2
// 3,3 - 0, +1

// 2,2
// 1,1 - -1, -1

// 2,1 - +1, 0

// n =5
// 0,0
// 1,0
// 2,0
// 3,0
// 4,0 - +1, 0

// 4,1
// 4,2
// 4,3
// 4,4  - 0, +1

// 3,3
// 2,2
// 1,1   - -1, -1

// 2,1
// 3,1 - +1, 0

// 3,2  - +1, +1

