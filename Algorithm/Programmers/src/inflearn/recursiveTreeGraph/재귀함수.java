package inflearn.recursiveTreeGraph;

import java.util.Scanner;

public class 재귀함수 {

    public static void solution(int n) {
        if(n != 0) {
            solution(n - 1);
            System.out.println("n = " + n);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}
