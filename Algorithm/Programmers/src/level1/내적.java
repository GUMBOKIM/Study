package level1;

public class 내적 {

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) answer += a[i] * b[i];
        return answer;
    }

    public static void main(String[] args) {
        int[][] a_arr = {{1, 2, 3, 4}, {-1, 0, 1}};
        int[][] b_arr = {{-3, -1, 0, 2}, {1, 0, -1}};

        for (int i = 0; i < 2; i++) {
            System.out.println(내적.solution(a_arr[i], b_arr[i]));
        }
    }
}