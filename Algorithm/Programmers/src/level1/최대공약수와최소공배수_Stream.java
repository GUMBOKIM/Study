package level1;

import java.util.Arrays;
import java.util.stream.Stream;

//https://programmers.co.kr/learn/courses/30/lessons/12940
public class 최대공약수와최소공배수_Stream {

    public static int[] solution(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);

        int find = Stream.iterate(1, i -> i + 1)
                .takeWhile(i -> i <= min)
                .filter(i -> min % i == 0)
                .mapToInt(i -> i)
                .filter(i -> max % i == 0).max().getAsInt();
        return new int[]{find, min * max / find};
    }

    public static void main(String[] args) {
        int n = 1222;
        int m = 11;
        System.out.println(Arrays.toString(최대공약수와최소공배수_Stream.solution(n, m)));
    }
}