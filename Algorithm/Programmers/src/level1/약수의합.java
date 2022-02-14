package level1;


import java.util.Stack;

public class 약수의합 {

    public static int solution(int n) {
        int answer = 0;
        double real_root = Math.sqrt(n);
        int root = (int) Math.ceil(real_root);

        if (root == real_root) answer += root;

        for (int i = 1; i < root; i++) if (n % i == 0) answer += (i + (n / i));
        return answer;
    }

    public static void main(String[] args) {

        int[] n_r = {
                12, 5
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(약수의합.solution(n_r[i]));
        }
    }
}