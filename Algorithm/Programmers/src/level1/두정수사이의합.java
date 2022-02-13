package level1;

public class 두정수사이의합 {

    public static long solution(int a, int b) {
        if (a == b) {
            return a;
        } else {
            long min = Math.min(a, b);
            long max = Math.max(a, b);
            return (min + max) * (max - min + 1) / 2L ;
        }
    }

    public static void main(String[] args) {
        int[] a_arr = {
                3, 3, 5
        };

        int[] b_arr = {
                5, 3, 3
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(두정수사이의합.solution(a_arr[i], b_arr[i]));
        }
    }
}