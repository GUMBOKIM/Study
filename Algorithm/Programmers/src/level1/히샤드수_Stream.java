package level1;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12947
public class 히샤드수_Stream {

    public static boolean solution(int x) {
        int sum = Arrays.stream(Integer.toString(x).split("")).map(Integer::parseInt).reduce(0, Integer::sum);
        return x % sum == 0;
    }
    public static void main(String[] args) {
        int a = 10;

        System.out.println(히샤드수_Stream.solution(a));
    }
}