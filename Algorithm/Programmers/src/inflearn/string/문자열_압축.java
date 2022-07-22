package inflearn.string;

import java.util.Arrays;
import java.util.Scanner;

public class 문자열_압축 {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = (s + " ").toCharArray();
        int count = 0;
        char now = chars[0];

        for (char c: chars) {
            if(now != c) {
                sb.append(now);
                if(count != 1) sb.append(count);
                now = c;
                count = 1;
            } else count++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.print(solution(s));
    }
}
