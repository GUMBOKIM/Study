package level1;

import java.util.Arrays;
import java.util.Comparator;

//https://programmers.co.kr/learn/courses/30/lessons/12933
public class 정수내림차순으로배치하기_Stream {

    public static long solution(long n) {
        String reduce = Arrays.stream(Long.toString(n).split("")).sorted(Comparator.reverseOrder()).reduce("", String::concat);
        return Long.parseLong(reduce);
    }
    public static void main(String[] args) {
        long a = 118372;

        System.out.println(정수내림차순으로배치하기_Stream.solution(a));
    }
}