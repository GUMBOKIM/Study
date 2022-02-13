package level1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순으로정렬하기 {

    public static String solution(String s) {
        String[] str_arr = s.split("");
        Arrays.sort(str_arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str: str_arr) sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s_arr = {
                "Zbcdefg"
        };


        for (int i = 0; i < 1; i++) System.out.println(문자열내림차순으로정렬하기.solution(s_arr[i]));
    }
}