package level1;

import java.util.Arrays;
import java.util.Comparator;


public class 문자열내마음대로정렬하기 {

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, Comparator.comparing(s -> s.substring(n, n + 1)));
        return strings;
    }

    public static void main(String[] args) {
        String[][] strings_arr = {
                {"sun", "bed", "car"},
                {"abce", "abcd", "cdx"},
        };

        int[] n_arr = {
                1, 2
        };

        for (int i = 0; i < 2; i++)
            System.out.println(Arrays.toString(문자열내마음대로정렬하기.solution(strings_arr[i], n_arr[i])));
    }
}