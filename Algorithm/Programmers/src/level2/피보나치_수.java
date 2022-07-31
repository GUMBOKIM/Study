package level2;

import java.util.Arrays;

public class 피보나치_수 {
    public static int solution(int n) {
        if(n == 1) return 1;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++){
            int temp = (a + b) % 1234567;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }


}
