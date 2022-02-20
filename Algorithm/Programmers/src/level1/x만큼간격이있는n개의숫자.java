package level1;

import java.util.Arrays;
import java.util.stream.Stream;

// https://programmers.co.kr/learn/courses/30/lessons/12931
public class x만큼간격이있는n개의숫자 {

    public static long[] solution(int x, int n) {
        long[] result = new long[n];
        for (int i = 0; i < n; i++) result[i] = (long) x * (i + 1);
        return result;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;

        System.out.println(Arrays.toString(x만큼간격이있는n개의숫자.solution(x, n)));
    }
}