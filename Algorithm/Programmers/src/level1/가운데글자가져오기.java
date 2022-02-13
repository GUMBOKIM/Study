package level1;

import java.util.Arrays;

public class 가운데글자가져오기 {

    public static String solution(String s) {
        int length = s.length();
        int start = length / 2;
        return length % 2 == 0 ? s.substring(start - 1, start + 1) : s.substring(start, start + 1);
    }

    public static void main(String[] args) {
        String[] s_arr = {
                "abcde",
                "qwer"
        };

        for (int i = 0; i < 2; i++) System.out.println(가운데글자가져오기.solution(s_arr[i]));
    }
}