package inflearn.recursiveTreeGraph;

import java.util.Scanner;

public class 이진수출력 {

    public static void solution(int n) {
        if (n == 0) return;
        int remainder = n % 2;
        solution(n / 2);
        System.out.print(remainder);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}
