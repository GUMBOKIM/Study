package inflearn.string;

import java.util.Scanner;

public class 팰린드롬 {

    public static String solution(String input) {
        input = input.toUpperCase().replaceAll("[^A-Z]", "");
        return input.equals(new StringBuilder(input).reverse().toString()) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print(solution(input));
    }
}
