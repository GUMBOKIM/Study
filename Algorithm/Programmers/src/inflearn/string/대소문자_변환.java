package inflearn.string;

import java.util.Scanner;

public class 대소문자_변환 {

    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray())
            sb.append(Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(solution(input));
    }
}
