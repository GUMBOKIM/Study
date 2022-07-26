package inflearn.recursiveTreeGraph;

import java.util.Scanner;

public class 팩토리얼 {

    public static int solution(int n) {
        return n == 1 ? 1 : n * solution(n -1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
