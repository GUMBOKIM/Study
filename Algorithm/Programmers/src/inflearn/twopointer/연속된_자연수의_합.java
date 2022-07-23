package inflearn.twopointer;

import java.util.Scanner;

public class 연속된_자연수의_합 {

    public static int solution(int N) {
        int answer = 0;
        int m = N / 2 + 1;
        int sum = 0;
        int lt = 0;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i + 1;
        for (int rt = 0; rt < m; rt++) {
            sum+=arr[rt];
            if(sum == N) answer++;
            while(sum >= N) {
                sum-=arr[lt++];
                if(sum==N) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(solution(N));
    }
}
