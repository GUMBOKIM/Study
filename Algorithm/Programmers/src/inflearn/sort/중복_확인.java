package inflearn.sort;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 중복_확인 {

    public static String solution(int n, int[] line) {
        HashSet<Integer> set = new HashSet<>();
        for (int number: line) {
            if(set.contains(number)) {
                return "D";
            } else {
                set.add(number);
            }
        }
        return "U";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] line = new int[n];
        for (int i = 0; i < n; i++) line[i] = sc.nextInt();
        System.out.print(solution(n, line));
    }
}
