package level1;

import java.util.Arrays;
// https://programmers.co.kr/learn/courses/30/lessons/12931
public class 자릿수더하기_Stream {
    
    public static int solution(int n) {
        return Arrays.stream(Integer.toString(n).split("")).map(Integer::parseInt).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        int N = 123;
        int N2 = 987;

        System.out.println(자릿수더하기_Stream.solution(N));
        System.out.println(자릿수더하기_Stream.solution(N2));
    }
}