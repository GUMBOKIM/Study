package level2;

public class _2XN타일링 {

    public static int solution(int n) {
        long[] memory = new long[n];
        memory[0] = 1;
        memory[1] = 2;
        for (int i = 2; i < n; i ++) memory[i] = (memory[i - 1] + memory[i - 2]) % (long) 1000000007;

        return (int) memory[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
