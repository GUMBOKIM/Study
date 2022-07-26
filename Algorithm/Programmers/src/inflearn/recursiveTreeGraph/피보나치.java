package inflearn.recursiveTreeGraph;

import java.util.Scanner;

public class 피보나치 {

    static int[] fibo;

    public static int solution(int n) {
        if(fibo[n] > 0) return fibo[n];
        if(n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = solution(n-1) + solution(n-2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n + 1];
        solution(n);
        for (int i = 0; i <= n; i++) System.out.print(fibo[i] + " ");
    }
}
