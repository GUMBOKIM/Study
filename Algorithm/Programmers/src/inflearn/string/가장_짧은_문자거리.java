package inflearn.string;

import java.util.Arrays;
import java.util.Scanner;

public class 가장_짧은_문자거리 {

    public static String solution(String s, char t) {
//        StringBuilder sb = new StringBuilder();
//        int left = s.indexOf(t);
//        int right = s.indexOf(t,left + 1);
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == t.charAt(0)) {
//                sb.append(0 + " ");
//                left = i;
//                right = s.indexOf(t, left + 1);
//            } else {
//                sb.append(Math.min(Math.abs(left - i), Math.abs(right-i)) + " ");
//            }
//        }
//        return sb.toString();

        int[] answer = new int[s.length()];
        int p = 1000;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for(int i=s.length() - 1; i >=0; i--) {
            if(s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return Arrays.toString(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);

        System.out.print(solution(s, t));
    }
}
