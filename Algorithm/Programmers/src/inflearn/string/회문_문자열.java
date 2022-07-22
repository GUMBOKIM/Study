package inflearn.string;

import java.util.Scanner;

public class 회문_문자열 {

    public static String solution(String input) {
//        input = input.toLowerCase();
//        int last = input.length() - 1;
//        for (int i = 0; i < last / 2; i++) if(input.charAt(i) != input.charAt(last - i)) return "NO";
//        return "YES";
        String reverse = new StringBuilder(input).reverse().toString();
        if(reverse.equalsIgnoreCase(input)) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(solution(input));
    }
}
