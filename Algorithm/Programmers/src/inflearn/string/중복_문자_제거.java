package inflearn.string;

import java.util.Scanner;

public class 중복_문자_제거 {

    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
//        while (input.length() > 0) {
//            String str = input.substring(0, 1);
//            sb.append(str);
//            input = input.replace(str, "");
//        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(input.indexOf(c) == i) sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.print(solution(input));
    }
}
