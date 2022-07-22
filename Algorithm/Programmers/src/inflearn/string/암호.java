package inflearn.string;

import java.util.Arrays;
import java.util.Scanner;

public class 암호 {

    public static String solution(int line, String s) {
        StringBuilder sb = new StringBuilder();
//        char[] chars = s.toCharArray();
//        int index = 0;
//        int sum = 0;
//        for (char c : chars) {
//            if (c == '#') {
//                sum = sum + (int) Math.pow(2, 6 - index);
//            }
//            if (index == 6) {
//                sb.append((char) sum);
//                index = 0;
//                sum = 0;
//            } else {
//                index ++;
//            }
//        }
        for (int i = 0; i < line; i++) {
            String tmp = s.substring(0,7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            sb.append((char) num);
            s = s.substring(7);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = sc.next();
        System.out.print(solution(i, s));
    }
}
